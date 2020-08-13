package com.hy.ssm.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: wangsq
 * @Date: 2020/8/3 16:47
 * @Description:
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @RequestMapping("/login")
    public String login(String username,String pwd){
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(username,pwd);
        //usernamePasswordToken.setRememberMe(true);
        //先拿到subject
        Subject subject=SecurityUtils.getSubject();
        try {
            subject.login(usernamePasswordToken);
        } catch (UnknownAccountException e) {

        }catch (IncorrectCredentialsException e){

        }finally {
        }
        return "/list.jsp";


    }
}
