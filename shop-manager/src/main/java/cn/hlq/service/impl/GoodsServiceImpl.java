package cn.hlq.service.impl;

import cn.hlq.common.pojo.Goods;
import cn.hlq.service.GoodsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
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
        logger.info("do nothing");
        return null;
    }
}
