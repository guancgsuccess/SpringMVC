package com.mybatis.controller;

import com.mybatis.pojo.ItemsCustom;
import com.mybatis.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 使用注解开发...
 * Created by Administrator on 2017/4/7 0007.\
 * 使用注解的映射器和注解的适配器(必须配对使用)
 *
 */
//使用该注解标识它是一个控制器
@Controller
//为了对url进行分类管理 ，可以在这里定义根路径，最终访问url是根路径+子路径
//比如：商品列表：/items/queryItems.action
@RequestMapping("/items")
public class ItemsController3 {
    @Autowired
    private ItemsService itemsService;
    //商品查询
    //该注解实现对queryItem方法和url进行映射,一个方法对应一个url
    //一般建议将url和方法写成一样
    @RequestMapping("/queryItemsList")
    public ModelAndView queryItems(HttpServletRequest req) throws Exception{

        //测试forward后request是否可以共享,所以在参数中添加HttpServletRequest参数
       // System.out.println(req.getParameter("itemsCustomId"));

        // 调用service查找数据库,查询商品列表
        List<ItemsCustom> itemsList = itemsService.findItemsList(null);

        // 返回ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        // 相当 于request的setAttribut，在jsp页面中通过itemsList取数据
        modelAndView.addObject("itemsList", itemsList);
        //指定视图...如果视图解析器配置了前缀和后缀的话

        modelAndView.setViewName("items/index");
        return modelAndView;
    }
    //可以定义其他的方法...
    //商品信息修改页面
    //限制http请求方法，可以post和get
/*   @RequestMapping(value = "/editItems",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView editItems() throws Exception{
        //根据id查询商品信息
        ItemsCustom itemsCustom = itemsService.findItemsById(1L);

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("itemsCustom",itemsCustom);

        //商品修改页面
        modelAndView.setViewName("items/editItems");

        return modelAndView;
    }*/

    /**
     * controller返回类型定义成String类型
     *12.2默认支持的类型
     * 直接在controller方法形参上定义下边类型的对象，就可以使用这些对象。在参数绑定过程中，如果遇到下边类型直接进行绑定。
     *
     * 1.2.1.1HttpServletRequest
     * 1.2.1.2HttpServletResponse
     * 1.2.1.3HttpSession
     * 1.2.1.4Model/ModelMap
     * model是一个接口，modelMap是一个接口实现 。
     * 作用：将model数据填充到request域。
     */
    @RequestMapping(value = "/editItems",method = {RequestMethod.GET,RequestMethod.POST})
    //public String editItems(Model model, HttpServletRequest req) throws Exception{

    //通过@RequestParam对简单类型的参数进行绑定。
    // 如果不使用@RequestParam，要求request传入参数名称和controller方法的形参名称一致，方可绑定成功。
    // public String editItems(Model model, Long id) throws Exception{
    // 如果使用@RequestParam，不用限制request传入参数名称和controller方法的形参名称一致。
    //通过required属性指定参数是否必须要传入，如果设置为true，没有传入参数，报下边错误：
    public String editItems(Model model,@RequestParam(value = "id",required = true,defaultValue = "1") Long items_id) throws Exception{

        //System.out.println(items_id);

        //根据id查询商品信息
       // ItemsCustom itemsCustom = itemsService.findItemsById(id);
        ItemsCustom itemsCustom = itemsService.findItemsById(items_id);

        ////通过形参中的model将model数据传到页面
        //相当于modelAndView.addObject方法
        model.addAttribute("itemsCustom",itemsCustom);

        return "items/editItems";
    }

    //Spring MVC 会按请求参数名和 POJO 属性名进行自动匹配，自动为该对象填充属性值。而且支持级联属性
    @RequestMapping(value = "/editItemsSubmit")
    public String editItemsSubmit(Long id,ItemsCustom itemsCustom) throws Exception{
        //重定向商品的查询页面
        //由于是同一个controller中的,所以/items可以省略不写...
        itemsService.updateItems(id,itemsCustom);

        //重定向商品的查询页面
        return "redirect:queryItemsList.action";

        //页面转发
        //return "forward:queryItemsList.action";
    }
}
