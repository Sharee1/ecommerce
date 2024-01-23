package com.ecommerce.ecommerce.service;
import com.ecommerce.ecommerce.entities.Product;
import com.ecommerce.ecommerce.entities.ShoppingCart;
import com.ecommerce.ecommerce.repositories.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService {
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    public ShoppingCart getShoppingCart(Long id) {
        return shoppingCartRepository.findById(id).orElse(null);
    }

    public void addToCart(ShoppingCart cart, Product product) {
        cart.getProducts().add(product);
        shoppingCartRepository.save(cart);
    }

    public void saveShoppingCart(ShoppingCart cart) {
        shoppingCartRepository.save(cart);
    }

    public void updateShoppingCart(Long id, ShoppingCart updatedCart) {
        ShoppingCart existingCart = shoppingCartRepository.findById(id).orElse(null);
        if (existingCart != null) {
            existingCart.setProducts(updatedCart.getProducts());


            shoppingCartRepository.save(existingCart);
        }
    }

    public void deleteShoppingCart(Long id) {
        shoppingCartRepository.deleteById(id);
    }

    public ShoppingCart createShoppingCart() {
        ShoppingCart newCart = new ShoppingCart();
        return shoppingCartRepository.save(newCart);
    }
}
