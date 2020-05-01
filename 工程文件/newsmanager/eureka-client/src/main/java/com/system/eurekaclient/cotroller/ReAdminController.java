package com.system.eurekaclient.cotroller;

import com.system.eurekaclient.service.ReAdminService;
import com.system.serviceribbon.bean.Admin;
import com.system.serviceribbon.bean.News;
import com.system.serviceribbon.bean.Result;
import com.system.serviceribbon.bean.User;
import org.apache.ibatis.annotations.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReAdminController {
    @Autowired
    ReAdminService reAdminService;

    @ResponseBody
    @PostMapping(value = "/admin")
    public Result login(@RequestBody Admin admin){
        System.out.println(admin.getAdmin_name());
        System.out.println(admin.getAdmin_pwd());
        Result login =reAdminService.login(admin);
        System.out.println(login.getMsg());
        System.out.println(login.getDetail());
        return login;
    }

    @ResponseBody
    @GetMapping(value = "/getallnews")
    public Result getnews(){
        Result getnews=reAdminService.getnews();
        System.out.println(getnews.getDetail());
        return getnews;
    }
    @ResponseBody
    @PostMapping(value = "/getnewsbytitle")
    public Result getnewsbytitle(@RequestBody News news){
        System.out.println(news.getNews_title());
        Result getnewsbytitle=reAdminService.getnewsbytitle(news.getNews_title());
        System.out.println(getnewsbytitle.getDetail());
        return getnewsbytitle;
    }
    @ResponseBody
    @PostMapping(value = "/insertnews")
    public Result insertnews(@RequestBody News news){
        System.out.println(news.getNews_content());
        Result insertnews = reAdminService.insertnews(news);
        return insertnews;
    }

    @ResponseBody
    @PostMapping(value = "/deletenews")
    public Result deletenews(@RequestBody int news_id){
        System.out.println(news_id);
        Result deletenews=reAdminService.deletenews(news_id);
        return deletenews;
    }

    @ResponseBody
    @PostMapping(value = "/updatenews")
    public Result updatenews(@RequestBody News news){
        Result updatenews =reAdminService.updatenews(news);
        return updatenews;
    }
}
