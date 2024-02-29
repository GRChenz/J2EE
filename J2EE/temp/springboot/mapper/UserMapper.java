package com.example.springboot.mapper;
/*
    @author GRChen
    2023/6/6 0006
*/

import com.example.springboot.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM sys_user")
    List<User> findAll();

    @Insert("INSERT INTO sys_user(username,password,nickname) VALUES(#{username},#{password},#{nickname})")
    int insert(User user);

    int update(User user);

    @Delete("delete from sys_user where id = #{id}")
    Integer deleteById(@Param("id") Integer id);

    @Select("select * from sys_user limit #{pageNum} , #{pageSize}")
    List<User> selectPage(Integer pageNum, Integer pageSize);

    @Select("select count(id) from sys_user")
    Integer selectTotal();
}
