package com.ecommerce.ecommerce.repositories;


import com.ecommerce.ecommerce.entities.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository  extends JpaRepository<ShoppingCart,Long> {



}
