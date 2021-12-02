package com.uguz.test;

import java.util.List;

import com.uguz.model.Advertisement;
import com.uguz.model.Education;
import com.uguz.model.UserDetail;
import com.uguz.model.UserInfo;
import com.uguz.model.User_;
import com.uguz.repository.AdvertisementRepository;
import com.uguz.repository.EducationRepository;
import com.uguz.repository.Repository;
import com.uguz.repository.UserDetailRepository;
import com.uguz.repository.UserRepository;

public class NamedQueryOperation {
	
	public Repository repository;
	
	
	public void UserQueryResultOperaration(UserRepository userRepository) {
		
		User_ user=userRepository.findById(1);
		System.out.println(user);
		
		User_ user2=userRepository.findByUserName("Enes123");
		System.out.println(user2);
		
		User_ user3= userRepository.findWithUserDetailByUserName("Kemal123");
		System.out.println(user3);
		
		List<User_> users=userRepository.findUsers();
		users.forEach(System.out::println);
		
		System.out.println("User count : "+userRepository.findUserCount());
		
		UserInfo userInfo=userRepository.findUserInfoByUserName("Enes123");
		System.out.println(userInfo);
		
	}
	
	public void userDetailQueryResultOperation(UserDetailRepository userDetailRepository ) {
		
		UserDetail userDetail=userDetailRepository.findById(2);
		System.out.println(userDetail);
		
		//
		UserDetail userDetail2=userDetailRepository.findByUserName("Kemal123");
		System.out.println(userDetail2);
		//
		UserDetail userDetail3=userDetailRepository.findWithAddressByUserName("Abdullah123");
		System.out.println(userDetail3);
		//
		UserDetail userDetail4=userDetailRepository.findWithAdvertisementByUserName("Abdullah123");
		System.out.println(userDetail4);
		
	}
	public void educationQueryResultOperation(EducationRepository educationRepository) {
	
		List<Education> educations=educationRepository.findEducations();
		educations.forEach(System.out::println);
		
		Education education1=educationRepository.findById(1);
		System.out.println(education1);
		
		//
		Education education2=educationRepository.findWithAdvertisementById(1);
		System.out.println(education2);
	}
	public void advertisementQueryResultOperaton(AdvertisementRepository advertisementRepository) {
		
		Advertisement advertisement1=advertisementRepository.findById(1);
		System.out.println(advertisement1);
		
		List<Advertisement> advertisements=advertisementRepository.findByUserName("Kemal123");
		advertisements.forEach(System.out::println);
	
		
		List<Advertisement> advertisements2=advertisementRepository.findAdvertisements();
		advertisements2.forEach(System.out::println);

	}

}
