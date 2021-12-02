package com.proje.service.impl;

import java.util.List;

import com.proje.service.EducationService;
import com.uguz.model.Education;
import com.uguz.repository.EducationRepository;
import com.uguz.repository.impl.EducationRepositoryImpl;

public class EducationServiceImpl implements EducationService {
	
	private EducationRepository educationRepository=new EducationRepositoryImpl();

	@Override
	public boolean save(Education education) {
		
		return this.educationRepository.save(education);
	}

	@Override
	public boolean update(Education education) {
		
		return this.educationRepository.update(education);
	}

	@Override
	public boolean remove(Education education) {
		
		return this.educationRepository.remove(education);
	}

	@Override
	public List<Education> findEducations() {
		
		return this.educationRepository.findEducations();
	}

	@Override
	public Education findById(int id) {
		
		return this.educationRepository.findById(id);
	}

	@Override
	public Education findWithAdvertisementById(int id) {
		
		return this.educationRepository.findWithAdvertisementById(id);
	}
	
	

}
