package cn.hlq.service.impl;

import cn.hlq.common.pojo.Orders;
import cn.hlq.service.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    private static Logger logger = LogManager.getLogger(OrderService.class);
    public Integer addOrder(Orders orders) {
        logger.info("do nothing");
        return null;
    }

    public List<Orders> queryOrders(Integer userId) {
        logger.info("do nothing");
        return null;
    }

    public Integer deleteOrders(Orders orders) {
        logger.info("do nothing");
        return null;
    }

    public Integer chageStatusOfOrders(Orders orders) {
        logger.info("do nothing");
        return null;
    }
}
