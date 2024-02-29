package com.example.springboot.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.entity.Dataprocessing;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.example.springboot.service.IProjectService;
import com.example.springboot.entity.Project;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author GRChen
 * @since 2023-06-09
 */
@RestController
@RequestMapping("/project")
public class ProjectController {

    @Resource
    private IProjectService projectService;

    // 新增或者更新
    @PostMapping
    public boolean save(@RequestBody Project project) {
        return projectService.saveOrUpdate(project);
    }

    @DeleteMapping("/{pid}")
    public Boolean delete(@PathVariable Integer pid) {
        return projectService.removeById(pid);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return projectService.removeByIds(ids);
    }

    @GetMapping
    public List<Project> findAll() {
        return projectService.list();
    }

    @GetMapping("/{pid}")
    public Project findOne(@PathVariable Integer pid) {
        return projectService.getById(pid);
    }

    //分页查询
    @GetMapping("/page")
    public Page<Project> findPage(@RequestParam Integer pageNum,
                                         @RequestParam Integer pageSize,
                                         @RequestParam(defaultValue = "") String project) {

        Page<Project> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Project> queryWrapper = new QueryWrapper<>();
        if (!"".equals(project)) {
            queryWrapper.like("project", project);
        }
        return projectService.page(new Page<>(pageNum, pageSize), queryWrapper);
    }
}
