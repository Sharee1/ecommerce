package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.entities.ShoppingCart;
import com.ecommerce.ecommerce.entities.Order; // Import your custom Order class
import com.ecommerce.ecommerce.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(ShoppingCart cart) {
        Order order = new Order();
        order.setProducts(cart.getProducts());
        orderRepository.save(order);
        return order;
    }

    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    public void updateOrder(Long orderId, Order updatedOrder) {
        Order existingOrder = orderRepository.findById(orderId).orElse(null);
        if (existingOrder != null) {
            existingOrder.setProducts(updatedOrder.getProducts());

            orderRepository.save(existingOrder);
        }
    }

    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
