package com.system.serviceribbonadmin.services;

import com.system.serviceribbon.bean.Admin;
import com.system.serviceribbon.bean.News;
import com.system.serviceribbon.bean.Result;
import com.system.serviceribbon.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AdminService {
    @Autowired
    RestTemplate restTemplate;
    //登录服务

    public Result login(Admin admin){
        return restTemplate.postForObject("http://SERVICE-CLIENT/admin",admin,Result.class);
    }

    public Result getnews() {
        return restTemplate.getForObject("http://SERVICE-CLIENT/getallnews",Result.class);
    }
    public Result getnewsbytitle(News news ) {

        System.out.println(news.getNews_title());
        return restTemplate.postForObject("http://SERVICE-CLIENT/getnewsbytitle",news,Result.class);
    }

    public Result insertnews(News news){
        return restTemplate.postForObject("http://SERVICE-CLIENT/insertnews",news,Result.class);
    }

    public Result deletenews(int news_id){
        return restTemplate.postForObject("http://SERVICE-CLIENT/deletenews",news_id,Result.class);
    }

    public Result updatenews(News news){
        return restTemplate.postForObject("http://SERVICE-CLIENT/updatenews",news,Result.class);
    }
}
