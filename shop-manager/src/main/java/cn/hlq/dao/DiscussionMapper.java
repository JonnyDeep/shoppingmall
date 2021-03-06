package cn.hlq.dao;

import cn.hlq.common.pojo.Discussion;
import org.apache.ibatis.annotations.Param;

public interface DiscussionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Discussion record);

    int insertSelective(Discussion record);

    Discussion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Discussion record);

    int updateByPrimaryKey(Discussion record);

    Integer queryDiscussionCountByGoodsId(@Param("goodsId") Integer goodsId);
}