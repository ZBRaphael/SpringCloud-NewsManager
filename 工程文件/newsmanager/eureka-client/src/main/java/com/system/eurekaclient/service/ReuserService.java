package com.system.eurekaclient.service;
import com.system.serviceribbon.bean.News;
import com.system.serviceribbon.bean.Result;
import com.system.serviceribbon.bean.User;
import com.system.eurekaclient.mapper.userMapper;
import com.system.eurekaclient.mapper.adminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
@Service
public class ReuserService {
        @Autowired
        private adminMapper adminmapper;
        @Autowired
        private userMapper userMapper;
        //登录服务
        public Result login(User user){
            Result res=new Result();
            res.setSuccess(false);
            res.setDetail(null);
            try {
                Integer userid = userMapper.login(user);
                if(userid == null){
                    res.setMsg("用户名或密码错误");
                }else{
                    res.setMsg("登录成功");
                    res.setSuccess(true);
                    user.setUser_id(userid);
                    res.setDetail(user);
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
    public Result getnewsbyid(int news_id){
        Result res=new Result();
        res.setSuccess(false);
        res.setDetail(null);
        try{
            List<News> news=userMapper.getnews(news_id);
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
        public Result regist( User user){

            Result result = new Result();
            result.setSuccess(false);
            result.setDetail(null);
            try{
                User existUser = userMapper.findUserByName(user.getUser_name());
                if (existUser != null){
                    result.setMsg("用户名已存在");

                }else {
                    userMapper.regist(user);
                    result.setMsg("ok");
                    result.setSuccess(true);
                    result.setDetail(user);
                }
            }catch (Exception e){
                result.setMsg(e.getMessage());
                e.printStackTrace();
            }
            return result;
        }


}
