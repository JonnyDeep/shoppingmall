package cn.hlq.dao;

import cn.hlq.common.pojo.GoodsProperty;

public interface GoodsPropertyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsProperty record);

    int insertSelective(GoodsProperty record);

    GoodsProperty selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsProperty record);

    int updateByPrimaryKey(GoodsProperty record);
}