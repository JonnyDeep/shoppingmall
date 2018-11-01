package cn.hlq.dao;

import cn.hlq.common.pojo.Customer;
import org.apache.ibatis.annotations.Param;

public interface CustomerMapperVol extends CustomerMapper {
   public Customer queryCustomerByUserName(@Param("customer") Customer customer);
}
