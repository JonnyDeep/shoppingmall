package cn.hlq.dao;

import cn.hlq.common.pojo.Discussion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DiscussionVolMapper {
    List<Discussion> selectByGoodsId(@Param("goodsId")Integer goodsId);
}
