package com.hy.ssm.pojo;

import java.io.Serializable;

/**
 * @Auther: wangsq
 * @Date: 2020/7/4 17:23
 * @Description:
 */
public class Classes implements Serializable{
    private Integer cno;
    private String classname;

    public Integer getCno() {
        return cno;
    }

    public void setCno(Integer cno) {
        this.cno = cno;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }
}
