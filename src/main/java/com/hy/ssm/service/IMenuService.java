package com.hy.ssm.service;

import com.baomidou.mybatisplus.service.IService;
import com.hy.ssm.pojo.SchoolMenu;
import com.hy.ssm.utils.MenuData;

import java.util.List;

/**
 * @Auther: wangsq
 * @Date: 2020/7/24 10:35
 * @Description:
 */
public interface IMenuService extends IService<SchoolMenu> {
    public List<MenuData> queryBase();

}
