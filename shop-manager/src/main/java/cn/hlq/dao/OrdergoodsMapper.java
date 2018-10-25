package cn.hlq.dao;

import cn.hlq.common.pojo.Ordergoods;

public interface OrdergoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Ordergoods record);

    int insertSelective(Ordergoods record);

    Ordergoods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Ordergoods record);

    int updateByPrimaryKey(Ordergoods record);
}