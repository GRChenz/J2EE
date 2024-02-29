package com.example.springboot.mapper;

import com.example.springboot.entity.Project;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author GRChen
 * @since 2023-06-09
 */
@Mapper
public interface ProjectMapper extends BaseMapper<Project> {

}
