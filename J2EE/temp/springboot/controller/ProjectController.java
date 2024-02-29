package com.example.springboot.controller;/*
    @author GRChen
    2023/6/7 0007
*/

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.entity.Project;
import com.example.springboot.mapper.ProjectMapper;
import com.example.springboot.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/project")
public class ProjectController {

//    @Autowired
//    private ProjectMapper projectMapper;

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public Boolean save(@RequestBody Project project){
        return  projectService.saveProject(project);
    }

    @DeleteMapping("/{p_id}")
    public boolean delete(@PathVariable String p_id){
        return  projectService.removeById(p_id);
    }

    @GetMapping
    public List<Project> findAll(){
        return  projectService.list();
    }
//    @GetMapping("/page")
//    public Map<String,Object> findAll(@RequestParam Integer pageNum,@RequestParam Integer pageSize,@RequestParam String p_id){
//        pageNum=(pageNum-1)*pageSize;
//        List<Project> data=projectMapper.selectPage(pageNum,pageSize,p_id);
//        Integer total=projectMapper.selectTotal(p_id);
//        Map<String,Object> res=new HashMap<>();
//        res.put("data",data);
//        res.put("total",total);
//        return  res;
//    }
    //mybatis-plus方式分页查询
    @GetMapping("/page")
    public IPage<Project> findPage(@RequestParam Integer pageNum,@RequestParam Integer pageSize,@RequestParam String p_id){
        IPage<Project> page =new Page<>(pageNum,pageSize);
        QueryWrapper<Project> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("p_id",p_id);
        return  projectService.page(page, queryWrapper);
    }
}
