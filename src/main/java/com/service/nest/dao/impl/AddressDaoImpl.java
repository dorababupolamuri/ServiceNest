package com.service.nest.dao.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.service.nest.dao.Address;
import com.service.nest.dao.AddressDao;
import com.service.nest.repository.AddressRepository;

@Component
public class AddressDaoImpl implements AddressDao{
	
	@Autowired
	private AddressRepository addressRepository;
	
	// for junit testing

	public AddressRepository getAddressRepository() {
		return addressRepository;
	}

	public void setAddressRepository(AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}

	@Override
	public Long saveAddress(Address address) {
		
		Address addrss =  addressRepository.save(address);
		return addrss.getId();
	}

	@Override
	public Optional<Address> getAddressById(Long Id) {
		
		return addressRepository.findById(Id);
	}

}
