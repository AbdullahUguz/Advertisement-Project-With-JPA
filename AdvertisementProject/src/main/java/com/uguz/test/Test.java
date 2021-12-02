package com.uguz.test;

import com.uguz.repository.AdvertisementRepository;
import com.uguz.repository.EducationRepository;

import com.uguz.repository.UserDetailRepository;
import com.uguz.repository.UserRepository;
import com.uguz.repository.impl.AdvertisementRepositoryImpl;
import com.uguz.repository.impl.EducationRepositoryImpl;
import com.uguz.repository.impl.UserDetailRepositoryImpl;
import com.uguz.repository.impl.UserRepositoryImpl;

public class Test {

	public static void main(String[] args) {

		UserRepository userRepository = new UserRepositoryImpl();

		UserDetailRepository userDetailRepository = new UserDetailRepositoryImpl();

		EducationRepository educationRepository = new EducationRepositoryImpl();

		AdvertisementRepository advertisementRepository = new AdvertisementRepositoryImpl();

		
		  InsertOperation insertOperation=new InsertOperation();
		  insertOperation.initialOperations();
		  
		  insertOperation.insertUserData(userRepository);
		  insertOperation.insertAdvertisementData(advertisementRepository);
		  insertOperation.insertEducationData(educationRepository);
		  insertOperation.insertUserDetailData(userDetailRepository);
		 		 

		NamedQueryOperation operation = new NamedQueryOperation();


		 operation.userDetailQueryResultOperation(userDetailRepository);

		 operation.educationQueryResultOperation(educationRepository);

		 operation.advertisementQueryResultOperaton(advertisementRepository);

	}
}
