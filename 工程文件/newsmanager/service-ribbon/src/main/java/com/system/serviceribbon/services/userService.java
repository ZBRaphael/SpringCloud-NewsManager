package com.system.serviceribbon.services;

import com.system.serviceribbon.bean.Result;
import com.system.serviceribbon.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class userService {
    @Autowired
    RestTemplate restTemplate;
    //登录服务

    public Result login(User user){
        return restTemplate.postForObject("http://SERVICE-CLIENT/login",user,Result.class);
    }
    public Result getnews() {
        return restTemplate.getForObject("http://SERVICE-CLIENT/getallnews1",Result.class);
    }
    public Result getnewsbyid(int news_id) {
        System.out.println(news_id);
        return restTemplate.postForObject("http://SERVICE-CLIENT/getnewsbyid",news_id,Result.class);
    }
    public Result regist(User user){
        return restTemplate.postForObject("http://SERVICE-CLIENT/register",user,Result.class);
    }
}
