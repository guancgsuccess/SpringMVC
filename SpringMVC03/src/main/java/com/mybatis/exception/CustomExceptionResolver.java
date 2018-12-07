package com.mybatis.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/4/19 0019.
 * 全局异常处理器
 */
public class CustomExceptionResolver implements HandlerExceptionResolver{
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //handler就是处理器适配器要执行Handler对象(只有method)

        //解析出异常类型
        //如果该异常类型是系统自定义的异常,直接取出异常信心,
        //在错误页面显示
       /* String message = null;

        if(ex instanceof CustomException){
            message = ((CustomException) ex).getMessages();
        }else{
            //如果该 异常类型不是系统 自定义的异常，构造一个自定义的异常类型（信息为“未知错误”）
            message = "未知错误";
        }*/

       //上边代码变为
        CustomException customException = null;

        if(ex instanceof CustomException){
            customException = (CustomException) ex;
        }else{
            System.out.println(ex.getMessage());
            customException = new CustomException("未知错误");
        }

        ModelAndView modelAndView = new ModelAndView();
        String message = customException.getMessage();
        //将错误信息传到页面k
        modelAndView.addObject("message",message);
        //指向错误页面
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
