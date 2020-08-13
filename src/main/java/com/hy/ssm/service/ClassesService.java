package com.hy.ssm.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hy.ssm.mapper.ClassesMapper;
import com.hy.ssm.pojo.Classes;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther: wangsq
 * @Date: 2020/7/21 16:21
 * @Description:
 */
@Service
@Transactional
public class ClassesService extends ServiceImpl<ClassesMapper,Classes> implements IClassesService{

}
