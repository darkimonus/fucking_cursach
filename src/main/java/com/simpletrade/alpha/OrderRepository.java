package com.simpletrade.alpha;

import com.simpletrade.alpha.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    Order customFindMethod(int id);
}
