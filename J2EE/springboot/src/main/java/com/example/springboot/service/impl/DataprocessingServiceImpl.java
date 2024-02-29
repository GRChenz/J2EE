package com.example.springboot.service.impl;

import com.example.springboot.entity.Dataprocessing;
import com.example.springboot.mapper.DataprocessingMapper;
import com.example.springboot.service.IDataprocessingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author GRChen
 * @since 2023-06-08
 */
@Service
public class DataprocessingServiceImpl extends ServiceImpl<DataprocessingMapper, Dataprocessing> implements IDataprocessingService {

}
