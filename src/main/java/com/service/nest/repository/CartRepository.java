package com.service.nest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.nest.dao.Cart;
import com.service.nest.dao.Service;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

	List<Service> findByCartId(Long cartId);
	
	Cart findByUserId(long userId);


}
