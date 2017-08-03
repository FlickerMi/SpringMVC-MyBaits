package cn.notemi.controller;

import cn.notemi.mapper.UserMapper;
import cn.notemi.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Title：LoginController
 * Description：登录
 *
 * @author Flicker
 * @create 2017-01-24 下午 5:57
 **/
@Controller
public class LoginController {
    @Resource
    private UserMapper userMapper;

    /**
     * 退出登录
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) throws Exception{
        // 清除session
        session.invalidate();
        return "redirect:/login";
    }
    /**
     * 登录
     * @return
     */
    @RequestMapping(value = "/doLogin")
    public String doLogin(HttpSession session,User user, Model model) throws Exception{
        User users = userMapper.login(user);
        if (users!=null){
            session.setAttribute("users",users);
            model.addAttribute("user",users);
            return "forward:/user/index";
        }else{
            model.addAttribute("message","密码错误或邮箱未注册！");
            return "login";
        }
    }
    @RequestMapping(value = "/login")
    public String login(){

        return "login";
    }
}
