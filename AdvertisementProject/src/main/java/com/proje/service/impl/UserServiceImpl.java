package com.proje.service.impl;

import java.util.List;

import com.proje.service.UserService;
import com.uguz.model.User_;
import com.uguz.model.UserInfo;
import com.uguz.repository.UserRepository;
import com.uguz.repository.impl.UserRepositoryImpl;

public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository=new UserRepositoryImpl();

	@Override
	public boolean save(User_ user) {
	
		return this.userRepository.save(user);
	}

	@Override
	public boolean update(User_ user) {
		
		return this.userRepository.update(user);
	}

	@Override
	public boolean remove(User_ user) {
		
		return this.userRepository.remove(user);
	}

	@Override
	public User_ findById(int id) {
		
		return this.userRepository.findById(id);
	}

	@Override
	public User_ findByUserName(String userName) {
		
		return this.userRepository.findByUserName(userName);
	}

	@Override
	public User_ findWithUserDetailByUserName(String userName) {
		
		return this.userRepository.findWithUserDetailByUserName(userName);
	}

	@Override
	public List<User_> findUsers() {
		
		return this.userRepository.findUsers();
	}

	@Override
	public List<User_> findUsers(int firstResult, int maxResult) {
		
		return this.userRepository.findUsers(firstResult, maxResult);
	}

	@Override
	public int findUserCount() {
		
		return this.userRepository.findUserCount();
	}

	@Override
	public UserInfo findUserInfoByUserName(String userName) {
		
		return this.userRepository.findUserInfoByUserName(userName);
	}
	
	

}
