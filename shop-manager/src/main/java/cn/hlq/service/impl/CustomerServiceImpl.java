package cn.hlq.service.impl;

import cn.hlq.common.pojo.Customer;
import cn.hlq.dao.CustomerMapper;
import cn.hlq.dao.CustomerMapperVol;
import cn.hlq.service.CustomerService;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    private static Logger logger = LogManager.getLogger(CustomerServiceImpl.class);
    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    CustomerMapperVol customerMapperVol;
    public int insertCustomer(Customer customer) {
        logger.info("customer:{}",customer);
        return customerMapper.insert(customer);
    }

    public Customer selectCustomerById(Integer id) {
        logger.info("dubbo service impl selectcustomerById id:{}",id);
        Customer customer = customerMapper.selectByPrimaryKey(id);
        logger.info("customer:{}",new Gson().toJson(customer));
        return customer;
    }

    public int deleteCustomerById(Integer id) {
        return customerMapper.deleteByPrimaryKey(id);
    }

    public int updateCustomerById(Customer customer) {
        return customerMapper.updateByPrimaryKey(customer);
    }

    public int updareCustomerBySelective(Customer customer) {
        return customerMapper.updateByPrimaryKeySelective(customer);
    }

    public Customer queryCustomerByUserName(Customer customer) {
        return customerMapperVol.queryCustomerByUserName(customer);
    }

    public List<Customer> selectExamples() {
        return customerMapper.selectExamples();
    }
}
