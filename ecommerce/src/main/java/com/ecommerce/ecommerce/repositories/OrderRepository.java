package com.ecommerce.ecommerce.repositories;

import com.ecommerce.ecommerce.entities.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
