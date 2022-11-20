package com.david.backend.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.david.backend.entity.OrderDetail;

@Repository
public interface OrderDetailDao extends CrudRepository<OrderDetail, Integer> {

}
