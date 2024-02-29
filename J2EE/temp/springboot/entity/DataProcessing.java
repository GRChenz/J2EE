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
@TableName(value = "t_dataprocessing")
public class DataProcessing {
    @TableId(value = "r_id")
    private String r_id;
    private String address;
    private String electricalconsume;
    private String datadif;
}
