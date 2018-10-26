package cn.hlq.service;

import cn.hlq.common.pojo.Goods;

import java.util.List;

public interface GoodsService {
    /**
     * seller exhibit new goods
     * @param goods
     * @return
     */
    public Integer exhibitGoods(Goods goods);

    /**
     * seller put off goods
     * @param goods
     * @return
     */
    public Integer withDrawGoods(Goods goods);

    /**
     * seller upadate the information of goods
     * @param goods
     * @return
     */
    public Integer updateGoodsInformation(Goods goods);

    /**
     * admin audit the goods of seller
     * @param goods
     * @return
     */
    public Integer validateGoods(Goods goods);

    /**
     * query goods
     * @return
     */
    public List<Goods> queryGoods();
}
