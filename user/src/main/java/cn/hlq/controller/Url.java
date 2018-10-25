package cn.hlq.controller;

import cn.hlq.filter.SystemLogoutFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class Url {
    private static Logger logger = LogManager.getLogger(Url.class);
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(String userName, String passwd, Model model)
    {
        logger.info("login username:{},passwd:{}",userName,passwd);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName,passwd);
        try {
            subject.login(token);

        }catch (UnknownAccountException e){
            e.printStackTrace();
            System.out.println("用户名错误");
            return "login";
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            System.out.println("密码错误");
            return "login";
        }
        return "index";
    }

}
