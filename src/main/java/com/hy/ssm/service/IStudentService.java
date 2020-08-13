package com.hy.ssm.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.hy.ssm.pojo.Student;

import java.util.List;

/**
 * @Auther: wangsq
 * @Date: 2020/7/24 10:35
 * @Description:
 */
public interface IStudentService extends IService<Student> {

    public List<Student> queryAll(Page page, Student student);
}
