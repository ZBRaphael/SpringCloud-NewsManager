package com.system.eurekaclient.cotroller;

import com.system.eurekaclient.service.ReuserService;
import com.system.serviceribbon.bean.Result;
import com.system.serviceribbon.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Controller
public class ReuserController {

    @Autowired
    ReuserService reuserService;

    @ResponseBody
    @PostMapping(value = "/login")
    public Result login(@RequestBody User user){
        System.out.println(user.getUser_name());
        System.out.println(user.getUser_pwd());
        Result login =reuserService.login(user);
        System.out.println(login.getMsg());
        System.out.println(login.getDetail());
        return login;
    }
    @ResponseBody
    @GetMapping(value = "/getallnews1")
    public Result getnews(){
        Result getnews=reuserService.getnews();
        System.out.println(getnews.getDetail());
        return getnews;
    }
    @ResponseBody
    @PostMapping(value = "/getnewsbyid")
    public Result getnews(@RequestBody int news_id){
        Result getnews=reuserService.getnewsbyid(news_id);
        System.out.println(getnews.getDetail());
        return getnews;
    }
    @ResponseBody
    @PostMapping(value = "/register")
    public Result regist(@RequestBody User user){
        System.out.println(user.getUser_name());
        System.out.println(user.getUser_pwd());
        Result regist = reuserService.regist(user);
        System.out.println(regist.getMsg());
        System.out.println(regist.getDetail());
        return regist;
    }
}
