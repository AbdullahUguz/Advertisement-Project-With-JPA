package com.uguz.repository;

import java.util.List;


import com.uguz.model.Education;
import com.uguz.model.entity.EntityClass;

public interface EducationRepository extends Repository {
	
	@Override
	boolean save(EntityClass entity);
	
	@Override
	boolean update(EntityClass entity);
	
	@Override
	boolean remove(EntityClass entity);
	
	List<Education> findEducations();
	
	Education findById(int id);
	
	Education findWithAdvertisementById(int id);
}
