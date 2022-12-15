package com.service.nest.dao;

import java.util.Optional;

public interface UserVaultDao {

	public Long saveUserVault(UserVault userVault);

	public Optional<UserVault> getEnduserById(Long userVaultId);

	public UserVault findByEmailId(String emailId);

}
