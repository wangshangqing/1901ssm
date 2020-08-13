package com.hy.ssm.utils;

import java.util.List;

/**
 * @Auther: wangsq
 * @Date: 2020/8/1 15:42
 * @Description:
 */
public class MenuData {
    private String title;
    private List children;

    public List getChildren() {
        return children;
    }

    public void setChildren(List children) {
        this.children = children;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
