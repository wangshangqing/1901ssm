package com.hy.ssm.realm;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.hy.ssm.pojo.Student;
import com.hy.ssm.service.IStudentService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: wangsq
 * @Date: 2020/8/3 16:42
 * @Description:
 */
public class MyRealm extends AuthorizingRealm{
    @Autowired
    private IStudentService studentService;

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("认证-----------------------");
        //获取到用户名
        UsernamePasswordToken usernamePasswordToken=(UsernamePasswordToken)authenticationToken;
        String username=usernamePasswordToken.getUsername();
        //根据用户名获取用户信息
        EntityWrapper entityWrapper=new EntityWrapper();
        entityWrapper.eq("stu_name",username);
        Student student=studentService.selectOne(entityWrapper);
        //查不到，就抛异常
        if(student==null){
            throw new UnknownAccountException("未知用户");
        }
        //返回认证的一个信息类
        ByteSource byteSource=ByteSource.Util.bytes(username);
        SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(student.getStuName(),student.getPwd(),byteSource,getName());
        return simpleAuthenticationInfo;
    }


    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权");

        //得到用户名
        Object obj=principalCollection.getPrimaryPrincipal();

        //根据用户名获取角色和权限

        Set<String> roles=new HashSet<String>();
        roles.add("admin");

        //权限
        Set<String> permission=new HashSet<String>();
        permission.add("update");
        permission.add("delete");
        permission.add("list");

        //返回授权的信息类
        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(roles);
        simpleAuthorizationInfo.setStringPermissions(permission);
        return simpleAuthorizationInfo;
    }
}
