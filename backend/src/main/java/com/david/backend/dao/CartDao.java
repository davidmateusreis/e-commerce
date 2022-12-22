package com.david.backend.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.david.backend.entity.Cart;

@Repository
public interface CartDao extends CrudRepository<Cart, Integer> {

}
