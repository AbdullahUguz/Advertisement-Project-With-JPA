package com.proje.service;

import com.uguz.model.UserDetail;

public interface UserDetailService {

	boolean save(UserDetail userDetail);

	boolean update(UserDetail userDetail);

	boolean remove(UserDetail userDetail);

	UserDetail findById(int id);

	UserDetail findByUserName(String userName);

	UserDetail findWithAddressByUserName(String userName);

	UserDetail findWithAdvertisementByUserName(String userName);
}
