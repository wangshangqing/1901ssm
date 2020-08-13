package com.hy.ssm;

import com.hy.ssm.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.util.StringUtils;

/**
 * @Auther: wangsq
 * @Date: 2020/7/24 10:24
 * @Description:
 */
public class SqlUtils {
    /**
     * 模糊查询学生
     * @param student
     * @return
     */
    public String queryAll(@Param("stu") Student student){
        StringBuffer stringBuffer=new StringBuffer("select * from student where 1=1 ");
        if(!StringUtils.isEmpty(student)){
            if(!StringUtils.isEmpty(student.getStuName())){
                stringBuffer.append(" and stu_name like '%${stuname}%' ");
            }
            if(!StringUtils.isEmpty(student.getSex())){
                stringBuffer.append(" and sex=#{sex}");
            }
        }
        return stringBuffer.toString();
    }
}
