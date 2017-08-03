package cn.notemi.controller;

import cn.notemi.po.User;
import cn.notemi.po.UserCustom;
import cn.notemi.po.UserQueryVo;
import cn.notemi.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * Title：UserCustom
 * Description：用户controller
 *
 * @author Flicker
 * @create 2017-01-17 下午 7:55
 **/
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Resource
    private UserService userService;

    /*批量修改*/
    //这里的值传到了UserQueryVo这个包装对象中
    @RequestMapping("/updateUserList")
    public String updateUserList(UserQueryVo userQueryVo) throws Exception{
        return  "redirect:editUserList";
    }
    @RequestMapping("/editUserList")
    public ModelAndView editUserList(ModelAndView modelAndView,UserQueryVo userQueryVo) throws Exception{
        List<UserCustom> userList = userService.selectChooseList(userQueryVo);
        //填充数据
        modelAndView.addObject("userList", userList);
        //视图
        modelAndView.setViewName("user/editList");
        return modelAndView;
    }
    /*批量删除*/
    //数组绑定
    @RequestMapping(value = "/deletes")
    public String deletes(Integer[] user_id) throws  Exception{
        for (int i=0;i<user_id.length-1;i++){
            userService.deleteById(user_id[i]);
        }
        //删除操作
        return "redirect:index";
    }
    /*添加操作*/
    @RequestMapping(value = "/added",method = RequestMethod.POST)
    public String added(Model model,
                        @Validated UserCustom userCustom,
                        BindingResult bindingResult,
                        MultipartFile photo_file) throws  Exception{
        //获取校验错误消息
        if (bindingResult.hasErrors()){
            //输出错误信息
            List<ObjectError> allErros = bindingResult.getAllErrors();
            for (ObjectError objectError:allErros){
                //输出错误信息
                System.out.println(objectError.getDefaultMessage());
            }
            model.addAttribute("error",allErros);
            //数据回显
            model.addAttribute("user",userCustom);
            return "user/add";
        }
        //原始名称
        String originalFilename = photo_file.getOriginalFilename();
        //上传图片
        if(photo_file!=null && originalFilename!=null && originalFilename.length()>0){

            //存储图片的物理路径
            String pic_path = "d:\\upload\\";

            //新的图片名称
            String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
            //新图片
            File newFile = new File(pic_path+newFileName);

            //将内存中的数据写入磁盘
            photo_file.transferTo(newFile);

            //将新图片名称写到itemsCustom中
            userCustom.setPhoto("/upload/"+newFileName);
            System.out.println("图片上传地址：/upload/"+newFileName);
        }
        userService.add(userCustom);
        return "redirect:index";

    }
    @RequestMapping(value = "/add")
    public String add() throws  Exception{
        return "user/add";
    }
    /*删除用户*/
    @RequestMapping(value = "/delete")
    public String delete(@RequestParam("id") Integer id) throws Exception{
        userService.deleteById(id);
        return "redirect:index";
    }
    /*更新*/
    @RequestMapping(value = "/update")
    public String update(UserCustom userCustom,MultipartFile photo_file) throws Exception{
        //原始名称
        String originalFilename = photo_file.getOriginalFilename();
        //上传图片
        if(photo_file!=null && originalFilename!=null && originalFilename.length()>0){

            //存储图片的物理路径
            String pic_path = "d:\\upload\\";

            //新的图片名称
            String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
            //新图片
            File newFile = new File(pic_path+newFileName);

            //将内存中的数据写入磁盘
            photo_file.transferTo(newFile);

            //将新图片名称写到itemsCustom中
            userCustom.setPhoto("/upload/"+newFileName);
            System.out.println("图片上传地址：/upload/"+newFileName);
        }
        userService.updateChoose(userCustom);
        return "redirect:index";
    }
    /*编辑*/
    @RequestMapping(value = "/edit")
    public String edit(@RequestParam(value = "id",required = true) Integer id,
                       Model model) throws Exception {
        User users = userService.selectById(id);
        System.out.println(users.toString());
        model.addAttribute("users",users);
        return "user/edit";
    }
    /*搜索*/
    @RequestMapping(value = "/search")
    public String search(Model model, UserQueryVo userQueryVo) throws Exception{
        List<UserCustom> userList = userService.selectChooseList(userQueryVo);
        model.addAttribute("userList",userList);
        return "user/index";
    }
    /*用户列表*/
    @RequestMapping(value = "/index")
    public ModelAndView index(ModelAndView modelAndView, UserQueryVo userQueryVo, HttpSession session) throws Exception {
        User users = (User) session.getAttribute("users");
        int id = users.getId();
        User user = userService.selectById(id);
        modelAndView.addObject("user",user);
        List<UserCustom> userList = userService.selectChooseList(userQueryVo);
        //填充数据
        modelAndView.addObject("userList", userList);
        //视图
        modelAndView.setViewName("user/index");
        return modelAndView;
    }
}
