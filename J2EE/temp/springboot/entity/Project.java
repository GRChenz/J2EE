package com.example.springboot.entity;/*
    @author GRChen
    2023/6/7 0007
*/

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "t_project") //使用mybatis-plus需要指定表名和主键
public class Project {
    @TableId(value = "p_id")
    private Integer p_id;
    private String project;
    private String p_address;
    private String description;
    private String p_time;
}
