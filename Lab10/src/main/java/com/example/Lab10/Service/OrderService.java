package com.example.Lab10.Service;

import com.example.Lab10.Model.Order;
import com.example.Lab10.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order updateOrder(Long id, Order order) {
        order.setId(id);
        return orderRepository.save(order);
    }

    public boolean deleteOrder(Long id) {
        if(orderRepository.findById(id).isEmpty()) {
            return false;
        }
        orderRepository.deleteById(id);
        return true;
    }

}
