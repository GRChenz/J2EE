package com.example.springboot.controller;/*
    @author GRChen
    2023/6/7 0007
*/

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.entity.DataProcessing;
import com.example.springboot.service.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/data")
public class DataController {

//    @Autowired
//    private DataProcessingMapper dataProcessingMapper;

    @Autowired
    private DataProcessingService dataProcessingService;

    @PostMapping
    public Boolean save(@RequestBody DataProcessing dataProcessing){
        return  dataProcessingService.saveDataProcessing(dataProcessing);
    }

    @DeleteMapping("/{r_id}")
    public boolean delete(@PathVariable String r_id){return  dataProcessingService.removeById(r_id);}

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids){return  dataProcessingService.removeByIds(ids);} //ids 类似于[1,2,3] 注意前端对象要对应

    @GetMapping
    public List<DataProcessing> findAll(){
        return dataProcessingService.list();
    }

    //分页
    @GetMapping("/page")
    public IPage<DataProcessing> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam String r_id){
        IPage<DataProcessing> page =new Page<>(pageNum,pageSize);
        QueryWrapper<DataProcessing> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("r_id",r_id);
        return  dataProcessingService.page(page, queryWrapper);
    }
}
