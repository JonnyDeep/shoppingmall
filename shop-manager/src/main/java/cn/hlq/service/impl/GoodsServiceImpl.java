package cn.hlq.service.impl;

import cn.hlq.common.pojo.Goods;
import cn.hlq.dao.GoodsMapper;
import cn.hlq.service.GoodsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsMapper goodsMapper;
    private static Logger logger = LogManager.getLogger(GoodsService.class.getName());
    public Integer exhibitGoods(Goods goods) {
        logger.info("do nothing");
        return null;
    }

    public Integer withDrawGoods(Goods goods) {
        logger.info("do nothing");
        return null;
    }

    public Integer updateGoodsInformation(Goods goods) {
        logger.info("do nothing");
        return null;
    }

    public Integer validateGoods(Goods goods) {
        logger.info("do nothing");
        return null;
    }

    public List<Goods> queryGoods() {
        logger.info("----> queryGoods");
        Goods goods= goodsMapper.selectByPrimaryKey(1);
        List<Goods> list = new ArrayList<Goods>();
        list.add(goods);
        return list;
    }
}
