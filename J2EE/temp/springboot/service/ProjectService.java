package com.example.springboot.service;/*
    @author GRChen
    2023/6/7 0007
*/

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot.entity.Project;
import com.example.springboot.mapper.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService  extends ServiceImpl<ProjectMapper,Project> {
    public Boolean saveProject(Project project) {
//        if(project.getP_id()==null){
//            save(project);
//        }else{
//            updateById(project);
//        }
//        boolean save= save(project); //mybatis-plus提供的方法,表示插入的数据
//        return false;
          return saveOrUpdate(project);
    }


//    save为mybatis-plus 关键字故不能用
//    @Autowired
//    private ProjectMapper projectMapper;
//
//    public String save(Project project){
//        if(project.getP_id()==null){
//            return  projectMapper.insert(project);
//        }else{
//            return  projectMapper.update(project);
//        }
//    }
}
