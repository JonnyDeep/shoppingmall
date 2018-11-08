package cn.hlq.dao;

import cn.hlq.common.pojo.GoodsZoomImages;

public interface GoodsZoomImagesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsZoomImages record);

    int insertSelective(GoodsZoomImages record);

    GoodsZoomImages selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsZoomImages record);

    int updateByPrimaryKey(GoodsZoomImages record);
}