package cn.hlq.service;


import cn.hlq.common.pojo.Orders;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.List;

public interface OrderService {

    /**
     * customer add an order when buy goods
     * @param orders
     * @return
     */
    public Integer addOrder(Orders orders);

    /**
     * query the orders of user who's id is userId
     * @param userId
     * @return
     */
    public List<Orders> queryOrders(Integer userId);


    /**
     * delete orders
     * @param orders
     * @return
     */
    public Integer deleteOrders(Orders orders);

    /**
     * change the status of orders,for example reject,not send goods
     * @return
     */
    public Integer chageStatusOfOrders(Orders orders);
}
