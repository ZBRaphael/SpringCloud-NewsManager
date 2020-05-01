package com.system.eurekaclient.mapper;
import com.system.serviceribbon.bean.News;



import com.system.serviceribbon.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface userMapper {

    /**
     * 登录
     * @param user
     * @return
     */
    @Select("select u.user_id from user u where u.user_name = #{user_name} and user_pwd = #{user_pwd}")
    Integer login(User user);
    /**
     * 查询用户名是否存在，若存在，不允许注册
     * 注解@Param(value) 若value与可变参数相同，注解可省略
     * 注解@Results  列名和字段名相同，注解可省略
     * @param user_name
     * @return
     */
    @Select(value = "select u.user_name,u.user_pwd from user u where u.user_name=#{user_name}")
    @Results
            ({@Result(property = "user_name",column = "user_name"),
                    @Result(property = "user_pwd",column = "user_pwd")})
    User findUserByName(@Param("user_name") String user_name);

    /**
     * 注册  插入一条user记录
     * @param user
     * @return
     */
    @Insert("insert into user(user_name,user_pwd,user_email) values(#{user_name},#{user_pwd},#{user_email})")
    //加入该注解可以保存对象后，查看对象插入user_id
    @Options(useGeneratedKeys = true,keyProperty = "user_id",keyColumn = "user_id")
    void regist(User user);
    @Select("select * from news where news_id = #{news_id}")
    @Results(id = "getallnews",value = {
            @Result(property = "news_id", column = "news_id"),
            @Result(property = "news_title",column = "news_title"),
            @Result(property = "news_content",column = "news_content"),
            @Result(property = "news_author",column = "news_author"),
            @Result(property = "columns_id",column = "columns_id")
    })
    List<News> getnews(@Param("news_id") int news_id);
}
