package com.example.springboot.mapper;/*
    @author GRChen
    2023/6/11 0011
*/

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.entity.Files;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileMapper extends BaseMapper<Files> {
}