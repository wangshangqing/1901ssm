package com.hy.ssm.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hy.ssm.mapper.StudentMapper;
import com.hy.ssm.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: wangsq
 * @Date: 2020/7/21 16:21
 * @Description:
 */
@Service
@Transactional
public class StudentService extends ServiceImpl<StudentMapper,Student> implements IStudentService{

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> queryAll(Page page, Student student){
        return studentMapper.queryAll(page,student);
    }
}
