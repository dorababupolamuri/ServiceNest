package com.service.nest.dao;

import java.util.List;
import java.util.Optional;

public interface IProfessionalUserService {

	public Long saveProfessionalUser(ProfessionalUserD professionalUser);

	public List<ProfessionalUserD> getAllProfessionalUsers();

	public Optional<ProfessionalUserD> getProfessionalUserById(Long professionalUserId);

	public boolean isExist(Long professionalUserId);

}
