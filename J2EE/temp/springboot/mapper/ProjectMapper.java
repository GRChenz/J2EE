package com.example.springboot.mapper;/*
    @author GRChen
    2023/6/7 0007
*/

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.entity.Project;
import org.apache.ibatis.annotations.*;

import java.util.List;

//@Mapper
public interface ProjectMapper extends BaseMapper<Project> {

//    @Select("SELECT * FROM t_project")
//    List<Project> findAll();
//
//    @Insert("INSERT INTO t_project(p_id,project,p_address,description) VALUES (#{p_id},#{project},#{p_address},#{description})")
//    int insert(Project project);
//
//    @Delete("delete from t_project where p_id=#{p_id}")
//    String deleteById(@Param("p_id") String p_id);
//
    String update(Project project);
//      mybatis-plus中有selectPage,导致selectpage被重写
//    @Select("select * from t_project where p_id like concat('%',#{p_id},'%') limit #{pageNum} , #{pageSize}")
//    List<Project> selectPage(Integer pageNum, Integer pageSize, String p_id);
//
//    @Select("select count(p_id) from t_project where p_id like concat('%',#{p_id},'%') ")
//    Integer selectTotal(String p_id);
}
