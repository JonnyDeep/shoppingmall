package cn.hlq;

import cn.hlq.common.pojo.Customer;
import cn.hlq.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class TestCustomer {
    @Autowired
    CustomerService customerService;

    @Test
    public void test(){
        List<Customer> list = customerService.selectExamples();
        list.stream().forEach(System.out::println);
    }
}
