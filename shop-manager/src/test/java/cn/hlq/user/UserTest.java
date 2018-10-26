package cn.hlq.user;

import cn.hlq.common.pojo.Customer;
import cn.hlq.dao.CustomerMapper;
import cn.hlq.common.utils.MD5Utils;
import cn.hlq.common.utils.PageResult;
import cn.hlq.service.CustomerService;
import com.github.pagehelper.PageHelper;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class UserTest {

    private static Logger logger = LogManager.getLogger(UserTest.class.getName());
    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    CustomerService customerService;

    @Test
    public void getUser()
    {
        logger.info(customerService);
        logger.info("begin {}","getUser");
        Customer customer=customerMapper.selectByPrimaryKey(1);
        Gson gson = new Gson();
        logger.info(gson.toJson(customer));
    }

    @Test
    public void testPageHelper()
    {
        logger.info("pageNum {},pageSize {}:",1,10);
        PageHelper.startPage(1,10);
        List<Customer> list = customerMapper.selectExamples();
        PageResult<Customer> result = new PageResult<Customer>(list);
        logger.info(result.toString());
    }


    @Test
    public void insertCustomer() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        logger.info("insert customer");
        Customer customer = new Customer();
        customer.setAge(22);
        customer.setCategory(2);
        Date date = new Date();
        logger.info(date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info(sdf.format(date));
        logger.info(date.getTime());
        customer.setGtmCreateTime(date.getTime());
        customer.setGtmModifyTime(date.getTime());
        customer.setSex((byte)1);
        customer.setUsername("lion");
        customer.setNickName("吃方便面的浣熊");
        customer.setHeadIamge("/home/shoppingmall/headimage/000b1231a.jpg");
        customer.setPassword(MD5Utils.MD5("000000"));
        customerMapper.insert(customer);
        logger.info("customer {}",new Gson().toJson(customer));
    }



}
