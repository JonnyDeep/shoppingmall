package cn.hlq.dao;

import cn.hlq.common.pojo.Customer;
import org.apache.ibatis.annotations.Param;

public interface CustomerVolMapper {
   public Customer queryCustomerByUserName(@Param("customer") Customer customer);
}
