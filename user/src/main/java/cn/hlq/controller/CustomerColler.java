package cn.hlq.controller;

import cn.hlq.common.pojo.Customer;
import cn.hlq.common.utils.JsonResult;
import cn.hlq.service.CustomerService;
import cn.hlq.service.TestService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/customer")
public class CustomerColler {

    private static Logger logger = LogManager.getLogger("mylog");
    @Autowired
    CustomerService customerService;
    @Autowired
    TestService testService;



    @RequiresRoles("customer")
    @RequestMapping(value = "/getCustomerInfo",method = RequestMethod.GET)
    public @ResponseBody JsonResult getCustomerInfo(@RequestParam Integer id)
    {
        logger.info("id:{}",id);
        Customer customer = customerService.selectCustomerById(id);
        logger.info("customer:{}",customer);
        logger.info("testService.getName:{}",testService.getName());
        JsonResult jsonResult = new JsonResult();
        jsonResult.setData(customer);
        return jsonResult;
    }

    @RequestMapping(value = "/delectCustomer",method = RequestMethod.DELETE)
    public @ResponseBody JsonResult deleteCustomer(@RequestParam Integer id)
    {
        JsonResult jsonResult = new JsonResult();
        return jsonResult;
    }


}
