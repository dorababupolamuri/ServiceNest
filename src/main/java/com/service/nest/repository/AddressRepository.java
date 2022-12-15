package com.service.nest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.nest.dao.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
