package cn.hlq.dao;

import cn.hlq.common.pojo.GoodspPropertyFilter;

public interface GoodspPropertyFilterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodspPropertyFilter record);

    int insertSelective(GoodspPropertyFilter record);

    GoodspPropertyFilter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodspPropertyFilter record);

    int updateByPrimaryKey(GoodspPropertyFilter record);
}