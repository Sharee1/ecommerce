package com.ecommerce.ecommerce.controller;


import com.ecommerce.ecommerce.entities.Product;
import com.ecommerce.ecommerce.entities.ShoppingCart;
import com.ecommerce.ecommerce.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shopping-carts")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @GetMapping("/{cartId}")
    public ShoppingCart getShoppingCart(@PathVariable Long cartId) {
        return shoppingCartService.getShoppingCart(cartId);
    }

    @PostMapping("/create")
    public void createShoppingCart() {
        shoppingCartService.createShoppingCart();
    }

    @PostMapping("/{cartId}/add-to-cart")
    public void addToCart(@PathVariable Long cartId, @RequestBody Product product) {
        ShoppingCart cart = shoppingCartService.getShoppingCart(cartId);
        shoppingCartService.addToCart(cart, product);
    }

    @PutMapping("/{cartId}")
    public void updateShoppingCart(@PathVariable Long cartId, @RequestBody ShoppingCart updatedCart) {
        shoppingCartService.updateShoppingCart(cartId, updatedCart);
    }

    @DeleteMapping("/{cartId}")
    public void deleteShoppingCart(@PathVariable Long cartId) {
        shoppingCartService.deleteShoppingCart(cartId);
    }
}

