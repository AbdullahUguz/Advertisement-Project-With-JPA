package com.uguz.repository;

import java.util.List;

import com.uguz.model.Advertisement;
import com.uguz.model.entity.EntityClass;

public interface AdvertisementRepository  extends Repository{

	@Override
	boolean save(EntityClass entity);
	
	@Override
	boolean update(EntityClass entity);
	
	@Override
	boolean remove(EntityClass entity);
	
	Advertisement findById(int id);
	
	List<Advertisement> findByUserName(String userName);
	
	List<Advertisement> findAdvertisements();
	
	List<Advertisement> findAdvertisementEntities(int firstResult,int maxResult);
	
	
}
