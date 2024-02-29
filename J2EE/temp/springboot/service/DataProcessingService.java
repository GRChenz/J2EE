package com.example.springboot.service;/*
    @author GRChen
    2023/6/7 0007
*/

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot.entity.DataProcessing;
import com.example.springboot.entity.Project;
import com.example.springboot.mapper.DataProcessingMapper;
import com.example.springboot.mapper.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataProcessingService extends ServiceImpl<DataProcessingMapper,DataProcessing> {

    public Boolean saveDataProcessing(DataProcessing dataProcessing) {
        return saveOrUpdate(dataProcessing);
    }
}
