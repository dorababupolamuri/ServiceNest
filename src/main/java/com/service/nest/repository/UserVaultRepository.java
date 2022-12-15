package com.service.nest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.nest.dao.UserVault;

@Repository
public interface UserVaultRepository extends JpaRepository<UserVault, Long> {

	public UserVault findByEmailId(String emailId);
	
	

}
