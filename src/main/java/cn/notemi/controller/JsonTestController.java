package cn.notemi.controller;

import cn.notemi.po.UserCustom;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Title：JsonTestController
 * Description：json交互测试
 *
 * @author Flicker
 * @create 2017-01-24 下午 2:25
 **/
@Controller
public class JsonTestController {

    //请求json串(商品信息)，输出json(商品信息)
    //@RequestBody将请求的商品信息的json串转成itemsCustom对象
    //@ResponseBody将itemsCustom转成json输出
    @RequestMapping(value = "/requestJson")
    public @ResponseBody UserCustom requestJson(@RequestBody UserCustom userCustom){

        //@ResponseBody将itemsCustom转成json输出
        return userCustom;
    }

    //请求key/value，输出json
    @RequestMapping("/responseJson")
    public @ResponseBody UserCustom responseJson(UserCustom userCustom){

        //@ResponseBody将itemsCustom转成json输出
        return userCustom;
    }
}
