package com.service.nest.dao;

import java.util.Optional;

public interface AddressDao {

	public Long saveAddress(Address address);

	public Optional<Address> getAddressById(Long Id);

}
