package com.proje.service;

import java.util.List;

import com.uguz.model.Education;

public interface EducationService {

	boolean save(Education education);

	boolean update(Education education);

	boolean remove(Education education);

	List<Education> findEducations();

	Education findById(int id);

	Education findWithAdvertisementById(int id);
}
