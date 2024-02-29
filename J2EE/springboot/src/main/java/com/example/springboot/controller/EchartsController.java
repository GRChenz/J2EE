package com.example.springboot.controller;/*
    @author GRChen
    2023/6/12 0012
*/

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.Quarter;
import cn.hutool.db.Db;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springboot.common.Result;
import com.example.springboot.entity.Dataprocessing;
import com.example.springboot.service.IDataprocessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/echarts")
public class EchartsController {

    @Autowired
    private IDataprocessingService dataprocessingService;

    @GetMapping("/weekcon")
    public Result get(){
        Map<String,Object> map =new HashMap<>();
        map.put("x", CollUtil.newArrayList("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"));
        map.put("y", CollUtil.newArrayList(150, 230, 224, 218, 135, 147, 260));
        return Result.success(map);
    }

    @GetMapping("/allconsume")
    public Result allConsume(){
        QueryWrapper<Dataprocessing> allconsume=new QueryWrapper<>();
        allconsume.select("IFNULL(sum(comnum),0)  AS comnum , IFNULL(sum(lignum),0) AS lignum , IFNULL(sum(fannum),0) AS fannum , IFNULL(sum(airnum),0) AS airnum");
        Map<String,Object> map =new HashMap<>(dataprocessingService.getMap(allconsume));
        System.out.println(map);
        return Result.success(map);
    }
}
