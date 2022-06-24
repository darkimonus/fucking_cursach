package com.simpletrade.alpha.dao;

import com.simpletrade.alpha.model.CourierOrder;
import com.simpletrade.alpha.model.Order;

import java.util.List;

public interface OrderDao {
    List<CourierOrder> getCourierListIncome();
    List<CourierOrder> getCourierListActive();
/*    void updateOrderStatus(int orderId);*/

}
