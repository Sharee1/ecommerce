package com.ecommerce.ecommerce.controller;
import com.ecommerce.ecommerce.entities.Order;
import com.ecommerce.ecommerce.entities.ShoppingCart;
import com.ecommerce.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public Order createOrder(@RequestBody ShoppingCart cart) {
        return orderService.createOrder(cart);
    }

    @GetMapping("/{orderId}")
    public Order getOrderById(@PathVariable Long orderId) {
        return orderService.getOrderById(orderId);
    }

    @PutMapping("/{orderId}")
    public void updateOrder(@PathVariable Long orderId, @RequestBody Order updatedOrder) {
        orderService.updateOrder(orderId, updatedOrder);
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
    }
}
