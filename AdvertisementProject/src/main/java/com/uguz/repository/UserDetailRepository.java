package com.uguz.repository;

import com.uguz.model.UserDetail;
import com.uguz.model.entity.EntityClass;

public interface UserDetailRepository extends Repository{
	
	@Override
	boolean save(EntityClass entity);
	
	@Override
	boolean update(EntityClass entity);
	
	@Override
	boolean remove(EntityClass entity);
	
	UserDetail findById(int id);
	
	UserDetail findByUserName(String userName);

	UserDetail findWithAddressByUserName(String userName);
	
	UserDetail findWithAdvertisementByUserName(String userName);
}
