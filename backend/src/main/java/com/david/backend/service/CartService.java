package com.david.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.david.backend.configuration.JwtRequestFilter;
import com.david.backend.dao.CartDao;
import com.david.backend.dao.ProductDao;
import com.david.backend.dao.UserDao;
import com.david.backend.entity.Cart;
import com.david.backend.entity.Product;
import com.david.backend.entity.User;

@Service
public class CartService {

    @Autowired
    private CartDao cartDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private UserDao userDao;

    public Cart addToCart(Integer productId) {
        Product product = productDao.findById(productId).get();
        String username = JwtRequestFilter.CURRENT_USER;

        User user = null;
        if (username != null) {
            user = userDao.findById(username).get();
        }

        if (product != null && user != null) {
            Cart cart = new Cart(product, user);
            return cartDao.save(cart);
        }

        return null;
    }

    public List<Cart> getCartDetails() {
        String username = JwtRequestFilter.CURRENT_USER;
        User user = userDao.findById(username).get();
        return cartDao.findByUser(user);
    }
}
