package com.system.serviceribbon.controller;

import com.system.serviceribbon.bean.Result;
import com.system.serviceribbon.bean.User;
import com.system.serviceribbon.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class userController {
    @Autowired
    private userService userservice;
    /**
     * 注册
     * @param user 参数封装
     * @return Result
     */
    @ResponseBody
    @PostMapping(value = "/regist")
    public String regist(User user,HttpServletResponse response){
        System.out.println(user.getUser_name());
        System.out.println(user.getUser_pwd());
        Result regist = userservice.regist(user);
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Cache-Control","no-cache");
        System.out.println(regist.getMsg());
        System.out.println(regist.getDetail());
        return regist.getMsg();
    }
    /**
     * 登录
     * @param user 参数封装
     * @return Result
     */
    @ResponseBody
    @PostMapping(value = "/login")
    public Result login(User user, HttpServletResponse response){

        Result login = userservice.login(user);
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Cache-Control","no-cache");
        System.out.println(login.getMsg());
        System.out.println(login.getDetail());
        return login;
    }
    @ResponseBody
    @RequestMapping("/getnews")
    public Result news_get(HttpServletResponse response){

        response.setHeader("Access-Control-Allow-Origin","*");

        Result getnews=userservice.getnews();
        System.out.println(getnews.getDetail());
        return getnews;
    }
    @ResponseBody
    @PostMapping("/getnewsbyid")
    public Result news_get(int news_id ,HttpServletResponse response){
        System.out.println("...............................................");
        System.out.println(news_id);
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Cache-Control","no-cache");
        response.setHeader("Access-Control-Allow-Headers", "DNT,X-Mx-ReqToken,Keep-Alive,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,Content-Type, Accept-Language, Origin, Accept-Encoding");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Result getnews=userservice.getnewsbyid(news_id);
        System.out.println(getnews.getDetail());
        return getnews;
    }
}
