package cn.hlq.service;

import cn.hlq.common.pojo.Customer;
import org.springframework.stereotype.Service;

/**
 * @author huangliqun
 *
 */

public interface CustomerService {
    /**
     * insert a user into customer table
     * @param customer the information
     */
    public int insertCustomer(Customer customer);

    /**
     * get the information of customer by his id
     * @param id the customer id
     * @return customer
     */
    public Customer selectCustomerById(Integer id);

    /**
     * delete a customer by his id
     * @param id the customer's identity
     * @return
     */
    public int deleteCustomerById(Integer id);

    /**
     * update a customer's information by his id
     * @param customer
     * @return
     */
    public int updateCustomerById(Customer customer);

    /**
     * update a some information of customer by his id
     * @param customer
     * @return
     */
    public int updareCustomerBySelective(Customer customer);


}
