package com.example.springboot.service.impl;

import com.example.springboot.entity.Project;
import com.example.springboot.mapper.ProjectMapper;
import com.example.springboot.service.IProjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author GRChen
 * @since 2023-06-09
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements IProjectService {

}
