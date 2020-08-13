package com.hy.ssm.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hy.ssm.SqlUtils;
import com.hy.ssm.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    @SelectProvider(type= SqlUtils.class,method = "queryAll")
    public List<Student> queryAll(Page page, @Param("stu") Student student);

}