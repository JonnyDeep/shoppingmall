package cn.hlq.dao;

import cn.hlq.common.pojo.GoodsCategory;

public interface GoodsCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsCategory record);

    int insertSelective(GoodsCategory record);

    GoodsCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsCategory record);

    int updateByPrimaryKey(GoodsCategory record);
}