package cn.hlq.controller;

import cn.hlq.common.pojo.Customer;
import cn.hlq.service.CustomerService;
import cn.hlq.service.TestService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    @RequestMapping(value = "/getCustomer",method = RequestMethod.GET)
    public @ResponseBody Customer getCustomer(@RequestParam Integer id)
    {
        logger.info("id:{}",id);
        Customer customer = customerService.selectCustomerById(id);
        logger.info("customer:{}",customer);
        logger.info("testService.getName:{}",testService.getName());
        return customer;
    }

}
