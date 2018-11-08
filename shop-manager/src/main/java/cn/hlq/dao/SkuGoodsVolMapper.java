package cn.hlq.dao;

import cn.hlq.common.pojo.SkuGoodsVol;

import java.util.List;

public interface SkuGoodsVolMapper {

    public List<SkuGoodsVol> queryGoods();

    public List<SkuGoodsVol> querySearchGoodsBy();
}
