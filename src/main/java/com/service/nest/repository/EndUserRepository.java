package com.service.nest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.nest.dao.EndUser;

@Repository
public interface EndUserRepository extends JpaRepository<EndUser, Long> {

}
