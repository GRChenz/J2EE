package com.example.springboot.mapper;/*
    @author GRChen
    2023/6/7 0007
*/

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.entity.DataProcessing;
import com.example.springboot.entity.Project;
import org.apache.ibatis.annotations.*;

import java.util.List;

//@Mapper
public interface DataProcessingMapper extends BaseMapper<DataProcessing> {

//    @Select("SELECT * FROM t_dataprocessing")
//    List<DataProcessing> findAll();
//
//    @Insert("INSERT INTO t_dataprocessing(r_id,address,electricalconsume) VALUES(#{r_id},#{address},#{electricalconsume})")
//    String insert (DataProcessing dataProcessing);
//
//    @Delete("delete from t_dataprocessing where r_id = #{r_id}")
//    String deleteByrId (@Param("r_id") String r_id);
//
    String update(DataProcessing dataProcessing);
//
//    @Select("select * from t_dataprocessing where r_id like concat('%',#{r_id},'%') limit #{pageNum} , #{pageSize}")
//    List<DataProcessing> selectPage(Integer pageNum, Integer pageSize,String r_id);
//
//    @Select("select count(r_id) from t_dataprocessing where r_id like concat('%',#{r_id},'%') ")
//    Integer selectTotal(String r_id);
//
//    @Update("UPDATE t_dataprocessing SET datadif=(DATEDIFF(curdate(),date_add(curdate(), interval - day(curdate())+ 1 day)))where r_id=#{r_id}")
//    String updateDate();
}
