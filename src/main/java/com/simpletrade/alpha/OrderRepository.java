package com.simpletrade.alpha;

import com.simpletrade.alpha.model.Order;
import com.simpletrade.alpha.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface OrderRepository extends JpaRepository<Order, Integer> {
    Optional<Order> findById(int findOrderStatusByStatus);
    @Query(value = "from Order o where o.status.id = 2")
    List<Order> getCourierOrdersIncome();
}
