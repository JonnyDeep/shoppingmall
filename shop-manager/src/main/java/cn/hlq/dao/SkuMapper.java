package cn.hlq.dao;

import cn.hlq.common.pojo.Sku;

public interface SkuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Sku record);

    int insertSelective(Sku record);

    Sku selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sku record);

    int updateByPrimaryKey(Sku record);
}