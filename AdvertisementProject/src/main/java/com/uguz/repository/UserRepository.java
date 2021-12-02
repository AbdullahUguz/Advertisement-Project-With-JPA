package com.uguz.repository;

import java.util.List;

import com.uguz.model.User_;
import com.uguz.model.entity.EntityClass;
import com.uguz.model.UserInfo;

public interface UserRepository extends Repository{

	@Override
	boolean save(EntityClass entity);
	
	@Override
	boolean update(EntityClass entity);
	
	@Override
	boolean remove(EntityClass entity);
	
	User_ findById(int id);
	
	User_ findByUserName(String userName);
	
	User_ findWithUserDetailByUserName(String userName);
	
	List<User_> findUsers();
	
	List<User_> findUsers(int firstResult,int maxResult);
	
	int findUserCount();
	
	UserInfo findUserInfoByUserName(String userName);
	
	
	
}
