package com.system.eurekaclient.mapper;

import com.system.serviceribbon.bean.Admin;
import com.system.serviceribbon.bean.News;
import com.system.serviceribbon.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Max;
import java.util.List;

@Mapper
@Repository
public interface adminMapper {
    /**
     * 登录
     * @param admin
     * @return
     */
    @Select("select a.admin_id from admin a where a.admin_name = #{admin_name} and admin_pwd = #{admin_pwd}")
    Integer login(Admin admin);

    @Select("select * from news")
    @Results(id = "getallnews",value = {
            @Result(property = "news_id", column = "news_id"),
            @Result(property = "news_title",column = "news_title"),
            @Result(property = "news_content",column = "news_content"),
            @Result(property = "news_author",column = "news_author"),
            @Result(property = "columns_id",column = "columns_id")
    })
    List<News> getnews();
    @Select("select * from news where news_title like CONCAT('%',#{news_title},'%') ")
    @Results(id = "getnewsbytitle",value = {
            @Result(property = "news_id", column = "news_id"),
            @Result(property = "news_title",column = "news_title"),
            @Result(property = "news_content",column = "news_content"),
            @Result(property = "news_author",column = "news_author"),
            @Result(property = "columns_id",column = "columns_id")
    })
    List<News> getnewsbytitle(String news_title);
    @Insert("insert into news(news_title,news_author,news_content,columns_id) values(#{news_title},#{news_author},#{news_content},#{columns_id})")
    @Options(useGeneratedKeys = true , keyProperty = "news_id", keyColumn = "news_id")
    void insertnews(News news);

    @Delete("delete from news where news_id = #{news_id}")
    int delete(@Param("news_id") int news_id);

    @Update("update news set news_title=#{news_title},news_author=#{news_author},news_content=#{news_content} where news_id=#{news_id}")
    int update(News news);
}
