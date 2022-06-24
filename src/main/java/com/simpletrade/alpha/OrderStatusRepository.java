package com.simpletrade.alpha;

import com.simpletrade.alpha.model.Order;
import com.simpletrade.alpha.model.OrderStatus;
import com.simpletrade.alpha.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, Integer> {
    List<OrderStatus> findOrderStatusByStatus(Status status);
}
