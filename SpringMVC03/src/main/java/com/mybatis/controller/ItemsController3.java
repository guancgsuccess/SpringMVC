package com.mybatis.controller;

import com.mybatis.controller.validation.ValidGroup1;
import com.mybatis.controller.validation.ValidGroup2;
import com.mybatis.pojo.ItemsCustom;
import com.mybatis.pojo.ItemsQueryVo;
import com.mybatis.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;

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

    // 商品分类
    //itemtypes表示最终将方法返回值放在request中的key
    @ModelAttribute("itemtypes")
    public Map<String, String> getItemTypes() {
        System.out.println("---------------");
        Map<String, String> itemTypes = new HashMap<>();
        itemTypes.put("101", "数码");
        itemTypes.put("102", "母婴");
        return itemTypes;
    }

    //包装类型POJO参数绑定
    @RequestMapping("/queryItemsList")
    public ModelAndView queryItems(ItemsQueryVo itemsQueryVo) throws Exception{

        //测试forward后request是否可以共享,所以在参数中添加HttpServletRequest参数
       // System.out.println(req.getParameter("itemsCustomId"));

        // 调用service查找数据库,查询商品列表
        List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);

        // 返回ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        // 相当 于request的setAttribut，在jsp页面中通过itemsList取数据
        modelAndView.addObject("itemsList", itemsList);
        //指定视图...如果视图解析器配置了前缀和后缀的话

        String icname="";
        //将查询的内容显示到查询输入框中.
        if (itemsQueryVo != null && itemsQueryVo.getItemsCustom()!=null && itemsQueryVo.getItemsCustom().getName()!=null) {
            icname = itemsQueryVo.getItemsCustom().getName();
        }
        modelAndView.addObject("icname",icname);

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
    public String editItems(Model model, @RequestParam(value = "id",required = true,
                                                        defaultValue = "1") Long items_id) throws Exception {
        //根据id查询商品信息
        // ItemsCustom itemsCustom = itemsService.findItemsById(id);
        ItemsCustom itemsCustom = itemsService.findItemsById(items_id);

        ////通过形参中的model将model数据传到页面
        //相当于modelAndView.addObject方法
        model.addAttribute("itemsCustom", itemsCustom);

        return "items/editItems";
    }

    //Spring MVC 会按请求参数名和 POJO 属性名进行自动匹配，自动为该对象填充属性值。而且支持级联属性
    //商品信息修改提交
    //在需要校验的pojo前边添加@Validated，在需要校验的pojo后边添加BindingResult
    //bindingResult接收校验出错信息
    //注意：@Validated和BindingResult bindingResult是配对出现，并且形参顺序是固定的（一前一后）。
    //@ModelAttribute可以指定pojo[基本类型不行]回显到页面在request中的key->推荐使用model
    //@MultipartFile接收图片名字
    @RequestMapping(value = "/editItemsSubmit")
    public String editItemsSubmit(HttpServletRequest req,MultipartFile items_pic,Model model, Long id,
                                  @Validated(value = {ValidGroup1.class, ValidGroup2.class})
                                  @ModelAttribute("itemsCustom")  ItemsCustom itemsCustom, BindingResult bindingResult) throws Exception{

       //获取校验错误信息
        if(bindingResult.hasErrors()) {
            //输出错误信息
            List<ObjectError> allErrors = bindingResult.getAllErrors();
          /*  for (ObjectError objectError : allErrors) {
                //输出错误信息
                System.out.println(objectError.getDefaultMessage());
            }*/

            String hpic = req.getParameter("hpic");
        //    System.out.println("hpic:"+hpic);
            if(null!=hpic){
                itemsCustom.setPic(hpic);
            }

            //id是不会使用d
          //model.addAttribute("id",id);
            //数据回显的推荐方式
        //    model.addAttribute("itemsCustom",itemsCustom);
            //将错误信息输出到页面
            model.addAttribute("allErrors", allErrors);
            return "items/editItems";
        }
        //原始名称
        String originalFilename = items_pic.getOriginalFilename();

        //上传图片
        if(items_pic!=null && originalFilename!=null && originalFilename.length()>0){
            //存储图片的物理路径.
            String pic_path = req.getServletContext().getRealPath("/")+"img/";
            //System.out.println(pic_path);/mvc03

            //新的图片名称
            String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
            //新图片
            File newFile = new File(pic_path+newFileName);

            //将内存中的数据写入磁盘
            items_pic.transferTo(newFile);
            //将新图片名称写到itemsCustom中
            itemsCustom.setPic(newFileName);
        }

        //重定向商品的查询页面
        //由于是同一个controller中的,所以/items可以省略不写...
        itemsService.updateItems(id,itemsCustom);

        return "redirect:queryItemsList.action";

        //页面转发
        //return "forward:queryItemsList.action";
    }

    /**
     * 删除,数组类型的参数绑定
     */
    @RequestMapping("/deleteItems")

    //使用集合的时候,必须添加@RequestParam
    // public String deleteItems(@RequestParam(value = "items_id")List<Long> items_id) throws Exception {

    public String deleteItems(Long[] items_id) throws Exception {
        // 调用service批量删除商品
        // ...
     //  for (int i = 0; i < items_id.length; i++) {
          //  itemsService.deleteById(items_id[i]);
      //  }
        return "redirect:queryItemsList.action";
    }

    /**
     * 接受批量更新的商品的id
     * 批量修改商品页面，将商品信息查询出来，在页面中可以编辑商品信息
     */
    @RequestMapping("/editItemsQuery")
    public String editItemsQuery(Model model,Long[] items_id) throws Exception{
        if (items_id != null && items_id.length>0) {
            List<ItemsCustom> itemsCustomsList = new ArrayList<>();

            for (Long id:items_id){
                //调用根据id查询商品信息
                itemsCustomsList.add(itemsService.findItemsById(id));
            }
            model.addAttribute("itemsList",itemsCustomsList);
        }
        return "items/editItemsQuery";
    }

    // 批量修改商品提交
    // 通过ItemsQueryVo接收批量提交的商品信息，将商品信息存储到itemsQueryVo中itemsList属性中。
    @RequestMapping("/editItemsAllSubmit")
    public String editItemsAllSubmit(ItemsQueryVo itemsQueryVo)
            throws Exception {
        if (itemsQueryVo != null) {
            for(ItemsCustom itemsCustom:itemsQueryVo.getItemsList()){
                itemsService.updateItems(itemsCustom.getId(),itemsCustom);
            }
        }
        return "redirect:queryItemsList.action";
    }

    //查询商品信息，输出json
    ///itemsView/{id}里边的{id}表示占位符，通过@PathVariable获取占位符中的参数，
    //如果占位符中的名称和形参名一致，在@PathVariable可以不指定名称
    //控制台输出.
    @RequestMapping("/itemsView/{id}")
    public @ResponseBody ItemsCustom itemsView(@PathVariable("id") Long id)throws Exception{

        //调用service查询商品信息
        ItemsCustom itemsCustom = itemsService.findItemsById(id);

        return itemsCustom;
    }
}
