package com.system.eurekaclient.service;

import com.system.eurekaclient.mapper.adminMapper;
import com.system.serviceribbon.bean.Admin;
import com.system.serviceribbon.bean.News;
import com.system.serviceribbon.bean.Result;
import com.system.serviceribbon.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReAdminService {
    @Autowired
    private adminMapper adminmapper;

    public Result login(Admin admin){
        Result res=new Result();
        res.setSuccess(false);
        res.setDetail(null);
        try {
            System.out.println(admin.getAdmin_name());
            Integer adminid = adminmapper.login(admin);
            System.out.println(admin.getAdmin_name());
            if(adminid == null){
                res.setMsg("用户名或密码错误");
            }else{
                res.setMsg("登录成功");
                res.setSuccess(true);
                admin.setId(adminid);
                res.setDetail(admin);
            }
        }catch (Exception e){
            res.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return res;
    }

    public Result getnews(){
        Result res=new Result();
        res.setSuccess(false);
        res.setDetail(null);
        try{
            List<News> news=adminmapper.getnews();
            if(news==null){
                res.setMsg("没有新闻信息");
            }else{
                res.setMsg("获取成功");
                res.setSuccess(true);
                res.setDetail(news);
            }
        }catch (Exception e){
            res.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return res;
    }
    public Result getnewsbytitle(String news_title){
        Result res=new Result();
        System.out.println(news_title);
        res.setSuccess(false);
        res.setDetail(null);
        try{
            List<News> news=adminmapper.getnewsbytitle(news_title);
            if(news==null){
                res.setMsg("没有新闻信息");
            }else{
                res.setMsg("获取成功");
                res.setSuccess(true);
                res.setDetail(news);
            }
        }catch (Exception e){
            res.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return res;
    }
    public Result insertnews(News news){
        Result res=new Result();
        res.setSuccess(false);
        res.setDetail(null);
        try {
            adminmapper.insertnews(news);
            res.setMsg("ok");
            res.setSuccess(true);
        }catch (Exception e){
            res.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return res;
    }

    public Result deletenews(int news_id){
        Result res=new Result();
        res.setSuccess(false);
        res.setDetail(null);
        try {
            int deletenews=adminmapper.delete(news_id);
            res.setMsg("ok");
            res.setSuccess(true);
            res.setDetail(deletenews);
        }catch(Exception e){
            res.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return res;
    }

    public Result updatenews(News news){
        Result res=new Result();
        res.setSuccess(false);
        res.setDetail(null);
        try {
            int updatenews = adminmapper.update(news);
            res.setMsg("ok");
            res.setSuccess(true);
            res.setDetail(updatenews);
        }catch (Exception e){
            res.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return res;
    }
}
