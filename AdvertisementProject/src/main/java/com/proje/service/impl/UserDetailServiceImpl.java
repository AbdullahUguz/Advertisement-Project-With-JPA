package com.proje.service.impl;

import com.proje.service.UserDetailService;
import com.uguz.model.UserDetail;
import com.uguz.repository.UserDetailRepository;
import com.uguz.repository.impl.UserDetailRepositoryImpl;

public class UserDetailServiceImpl implements UserDetailService{
	
	private UserDetailRepository userDetailRepository=new UserDetailRepositoryImpl();

	@Override
	public boolean save(UserDetail userDetail) {
		
		return this.userDetailRepository.save(userDetail);
	}

	@Override
	public boolean update(UserDetail userDetail) {
		
		return this.userDetailRepository.update(userDetail);
	}

	@Override
	public boolean remove(UserDetail userDetail) {
		
		return this.userDetailRepository.remove(userDetail);
	}

	@Override
	public UserDetail findById(int id) {
		
		return this.userDetailRepository.findById(id);
	}

	@Override
	public UserDetail findByUserName(String userName) {
		
		return this.userDetailRepository.findByUserName(userName);
	}

	@Override
	public UserDetail findWithAddressByUserName(String userName) {
		
		return this.userDetailRepository.findWithAddressByUserName(userName);
	}

	@Override
	public UserDetail findWithAdvertisementByUserName(String userName) {
		
		return this.userDetailRepository.findWithAdvertisementByUserName(userName);
	}
	
	

}
