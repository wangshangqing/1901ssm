package com.hy.ssm.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hy.ssm.mapper.MenuMapper;
import com.hy.ssm.pojo.SchoolMenu;
import com.hy.ssm.utils.MenuData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: wangsq
 * @Date: 2020/7/21 16:21
 * @Description:
 */
@Service
@Transactional
public class MenuService extends ServiceImpl<MenuMapper,SchoolMenu> implements IMenuService{
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<MenuData> queryBase(){
        List<MenuData> list1=new ArrayList<>();
        EntityWrapper entityWrapper=new EntityWrapper();
        entityWrapper.eq("pid","-1");
        List<SchoolMenu> list=menuMapper.selectList(entityWrapper);
        for(SchoolMenu schoolMenu:list){
            MenuData menuData=new MenuData();
            menuData.setTitle(schoolMenu.getName());

            EntityWrapper entityWrapper1=new EntityWrapper();
            entityWrapper1.eq("pid",schoolMenu.getId());
            List<SchoolMenu> list2=menuMapper.selectList(entityWrapper1);
            List<MenuData> list3=new ArrayList<>();
            for(SchoolMenu SchoolMenu2:list2){
                MenuData menuData2=new MenuData();
                menuData2.setTitle(SchoolMenu2.getName());
                EntityWrapper entityWrapper2=new EntityWrapper();
                entityWrapper2.eq("pid",schoolMenu.getId());
                List<SchoolMenu> list4=menuMapper.selectList(entityWrapper2);
                List<MenuData> list5=new ArrayList<>();
                for(SchoolMenu SchoolMenu3:list4){
                    MenuData menuData3=new MenuData();
                    menuData3.setTitle(SchoolMenu3.getName());
                    list5.add(menuData3);
                }
                menuData2.setChildren(list5);
                list3.add(menuData2);
            }
            menuData.setChildren(list3);

            list1.add(menuData);
        }
        return list1;
    }
}
