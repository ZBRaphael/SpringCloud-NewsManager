package com.system.serviceribbonadmin.controller;

import com.system.serviceribbon.bean.Admin;
import com.system.serviceribbon.bean.News;
import com.system.serviceribbon.bean.Result;
import com.system.serviceribbon.bean.User;
import com.system.serviceribbonadmin.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    //管理员登录
    @ResponseBody
    @PostMapping(value = "/login")
    public Result login(Admin admin, HttpServletResponse response){
        System.out.println(admin.getAdmin_name());
        System.out.println(admin.getAdmin_pwd());
        Result login = adminService.login(admin);
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Cache-Control","no-cache");
        System.out.println(login.getMsg());
        System.out.println(login.getDetail());
        return login;
    }

    //获取信息
    @ResponseBody
    @RequestMapping("/getnews")
    public Result news_get(HttpServletResponse response){

        response.setHeader("Access-Control-Allow-Origin","*");

        Result getnews=adminService.getnews();
        System.out.println(getnews.getDetail());
        return getnews;
    }
    //获取信息
    @ResponseBody
    @RequestMapping("/getnewsbytitle")
    public Result news_getbytitle(String news_title,HttpServletResponse response){
        System.out.println(news_title);
        News news=new News();
        news.setNews_title(news_title);
        response.setHeader("Access-Control-Allow-Origin","*");

        Result getnewsbytitle=adminService.getnewsbytitle(news);
        System.out.println(getnewsbytitle.getDetail());
        return getnewsbytitle;
    }
    //新增
    @ResponseBody
    @PostMapping(value = "/newsinsert")
    public Result news_insert(News news,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Cache-Control","no-cache");
        response.setHeader("Access-Control-Allow-Headers", "DNT,X-Mx-ReqToken,Keep-Alive,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,Content-Type, Accept-Language, Origin, Accept-Encoding");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        System.out.println(news);
        System.out.println(news.getColumns_id());
        System.out.println(news.getNews_title());
        Result news_insert=adminService.insertnews(news);
        return news_insert;
    }

    //删除
    @ResponseBody
    @PostMapping(value = "/newsdelete")
    public Result news_delete(int news_id,HttpServletResponse response){
        System.out.println(news_id);
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Cache-Control","no-cache");
        response.setHeader("Access-Control-Allow-Headers", "DNT,X-Mx-ReqToken,Keep-Alive,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,Content-Type, Accept-Language, Origin, Accept-Encoding");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Result news_delete = adminService.deletenews(news_id);
        return news_delete;
    }

    //修改
    @ResponseBody
    @PostMapping(value = "/newsupdate")
    public Result news_update(News news,HttpServletResponse response){

        System.out.println("-----------------------------------------");
        System.out.println(news.getNews_content());
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Cache-Control","no-cache");
        response.setHeader("Access-Control-Allow-Headers", "DNT,X-Mx-ReqToken,Keep-Alive,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,Content-Type, Accept-Language, Origin, Accept-Encoding");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Result news_update = adminService.updatenews(news);
        return news_update;
    }
}
