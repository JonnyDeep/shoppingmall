package cn.hlq.controller;

import cn.hlq.annotation.SystemLog;
import cn.hlq.auth.CustomRealm;
import cn.hlq.common.pojo.Customer;
import cn.hlq.common.utils.Exception.CustomException;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class Url {
    private static Logger logger = LogManager.getLogger(Url.class);

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @SystemLog(module = "用户系统",methods = "日志管理-用户登入" )
    public String login(@RequestBody Customer customer) throws Exception {
        logger.info("login username:{},passwd:{}",customer.getUsername(),customer.getPassword());
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(customer.getUsername(),customer.getPassword());
        try {
            subject.login(token);
            subject.hasRole("user:add");
        }catch (UnknownAccountException ex){
            logger.info("-------------errormessage:{},{}",ex.getMessage(),"用户名错误");
            throw new CustomException("用户名错误！");
        }catch (IncorrectCredentialsException ex){
            logger.info("-------------errormessage:{},{}",ex.getMessage(),"密码错误");
            throw new CustomException("密码错误");
        }
        return "index";
    }

}
