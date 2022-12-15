package com.service.nest.util;

import java.util.LinkedList;
import java.util.List;

import com.service.nest.dao.Address;
import com.service.nest.dao.ProfessionalUserD;
import com.service.nest.dao.UserVault;
import com.service.nest.domainI.ProfessionalUser;
import com.service.nest.domainI.UserAddress;

public class ServiceUtils {

	public static ProfessionalUserD getProfUserd(ProfessionalUser pUser) {
		ProfessionalUserD profUserD = new ProfessionalUserD();
		profUserD.setMobileNumber(pUser.getMobileNumber());
		profUserD.setUserName(pUser.getName());
		profUserD.setAvailable(pUser.isAvailable());
		profUserD.setCertificates(pUser.getCertificates());
		profUserD.setDepartment(pUser.getDepartment());
		profUserD.setExperience(pUser.getExperience());
		profUserD.setOverallRating(pUser.getOverallRating());
		profUserD.setServiceType(pUser.getServiceType());
		profUserD.setServingCity(pUser.getServingCity());
		profUserD.setSpeciality(pUser.getSpeciality());
		if(pUser.getAddress()!=null) {
		List<Address> address = getAddresses(pUser.getAddress(), profUserD);
		profUserD.setAddress(address);
		}
		UserVault userVault = new UserVault();
		userVault.setEmailId(pUser.getEmailId());
		userVault.setPassword(pUser.getPassword());
		profUserD.setUserVault(userVault);
		return profUserD;
	}

	public static List<Address> getAddresses(List<UserAddress> userAdresses, ProfessionalUserD pUsr) {
		List<Address> addrList = new LinkedList<Address>();
		for (UserAddress userAddress : userAdresses) {

			Address add = new Address();
			add.setCity(userAddress.getCity());
			add.setStreetAddress(userAddress.getStreetAddress());
			add.setCountry(userAddress.getCountry());
			add.setPinCode(userAddress.getZipCode());
			add.setProfessionalUser(pUsr);
			addrList.add(add);

		}
		return addrList;
	}

	public static ProfessionalUser getProfUser(ProfessionalUserD pUserd) {

		ProfessionalUser puser = new ProfessionalUser();
		puser.setMobileNumber(pUserd.getMobileNumber());
		puser.setName(pUserd.getUserName());
		puser.setAvailable(pUserd.isAvailable());
		puser.setCertificates(pUserd.getCertificates());
		puser.setDepartment(pUserd.getDepartment());
		puser.setExperience(pUserd.getExperience());
		puser.setOverallRating(pUserd.getOverallRating());
		puser.setServiceType(pUserd.getServiceType());
		puser.setServingCity(pUserd.getServingCity());
		puser.setSpeciality(pUserd.getSpeciality());
		if(pUserd.getAddress()!=null) {
		List<UserAddress> address = getAddressD(pUserd.getAddress(), puser);
		puser.setAddress(address);
		}
		puser.setEmailId(pUserd.getUserVault().getEmailId());
		puser.setPassword(pUserd.getUserVault().getPassword());
		return puser;

	}

	public static List<UserAddress> getAddressD(List<Address> userAdresses, ProfessionalUser pUsr) {
		List<UserAddress> addrList = new LinkedList<>();
		for (Address userAddress : userAdresses) {

			UserAddress add = new UserAddress();
			add.setCity(userAddress.getCity());
			add.setStreetAddress(userAddress.getStreetAddress());
			add.setCountry(userAddress.getCountry());
			add.setZipCode(userAddress.getPinCode());
			add.setpUser(pUsr);
			addrList.add(add);

		}
		return addrList;
	}

}
