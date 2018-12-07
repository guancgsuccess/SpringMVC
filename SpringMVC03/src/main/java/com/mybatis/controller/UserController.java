package com.mybatis.controller;

import com.mybatis.pojo.MybatisUser;
import com.mybatis.pojo.User;
import com.mybatis.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户登录控制器
 * Created by Administrator on 2017/4/22 0022.
 */
@Controller
@RequestMapping("/user")
//@SessionAttributes("user")
public class UserController {
    @Autowired
    private IUserService userService;

    //访问登录界面
    @RequestMapping("/loginView")
    public String userView(){
        return "user/login";
    }

    //登录处理
    @RequestMapping("/login")
    public String userLogin(String username,String password,Model model,HttpSession session){
        User user = userService.findByUsername(username);
        //判断用户名是否正确
        if(user!=null){
            //获取用户的密码
            if(user.getPassword().equals(password)){
                session.setAttribute("user",user);
                return "redirect:/items/queryItemsList";
            }else{
                //创建Map集合,用来保存错误信息
                Map<String,String> errorsMap = new HashMap<>();
              //  System.out.println("密码错误");
                errorsMap.put("pwd","密码错误!");
                model.addAttribute("errorsMap",errorsMap);
            }
        }else{
            Map<String,String> errorsMap = new HashMap<>();
           // System.out.println("用户名不正确!");
            errorsMap.put("usernull","用户不存在!");
            model.addAttribute("errorsMap",errorsMap);
        }
        return "user/login";
    }

    /**用户安全退出**/
    @RequestMapping("/logout")
    public String exit(HttpSession session){
        session.invalidate();//清空sessoin
        //重定向到商品列表页面
        return "redirect:/items/queryItemsList";
    }
}
