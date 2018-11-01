package cn.hlq.controller;

import cn.hlq.annotation.SystemLog;

import cn.hlq.common.pojo.Customer;

import cn.hlq.common.utils.Exception.CustomException;
import cn.hlq.common.utils.JsonResult;

import cn.hlq.common.utils.MD5Utils;
import cn.hlq.common.utils.ResultCode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@Controller
public class Url {
    private static Logger logger = LogManager.getLogger(Url.class);

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @SystemLog(module = "用户系统",methods = "日志管理-用户登入" )
    public @ResponseBody JsonResult login(@RequestBody Customer customer) throws Exception {
        logger.info("login username:{},passwd:{}",customer.getUsername(),customer.getPassword());
        logger.info("login username:{},passwd:{}",customer.getUsername(),customer.getPassword());
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(customer.getUsername(),MD5Utils.MD5(customer.getPassword()));
        try {
            subject.login(token);
//            Session session=subject.getSession();
//            logger.info("----- session id:{}",session.getId());
//            Collection c = session.getAttributeKeys();
//            c.stream().forEach(v->{logger.info("key:{},value:{}",v,session.getAttribute(v));});
        }catch (UnknownAccountException ex){
            logger.info("-------------errormessage:{},{}",ex.getMessage(),"用户名错误");
            throw new CustomException("用户名错误！");
        }catch (IncorrectCredentialsException ex){
            logger.info("-------------errormessage:{},{}",ex.getMessage(),"密码错误");
            throw new CustomException("密码错误");
        }

        JsonResult jsonResult = new JsonResult(ResultCode.SUCCESS);
        jsonResult.setData(customer);
        logger.info(jsonResult.toString());
        return jsonResult;
    }




}
