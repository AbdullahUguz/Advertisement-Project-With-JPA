package com.proje.service;

import java.util.List;

import com.uguz.model.User_;
import com.uguz.model.UserInfo;

public interface UserService {

	boolean save(User_ user);

	boolean update(User_ user);

	boolean remove(User_ user);

	User_ findById(int id);

	User_ findByUserName(String userName);

	User_ findWithUserDetailByUserName(String userName);

	List<User_> findUsers();

	List<User_> findUsers(int firstResult, int maxResult);

	int findUserCount();

	UserInfo findUserInfoByUserName(String userName);
}
