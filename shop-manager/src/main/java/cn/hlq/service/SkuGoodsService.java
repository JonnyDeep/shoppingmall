package cn.hlq.service;

import cn.hlq.common.pojo.SkuGoodsVol;
import cn.hlq.common.utils.PageResult;

public interface SkuGoodsService {

    /**
     * query all sell goods
     * @return
     */
    public PageResult<SkuGoodsVol> queryGoods(Integer startPage,Integer pageSize);
    public PageResult<SkuGoodsVol> querySearchGoodsBy();
}
