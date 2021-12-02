package com.uguz.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.uguz.model.Address;
import com.uguz.model.Advertisement;
import com.uguz.model.Education;
import com.uguz.model.UserDetail;
import com.uguz.model.User_;
import com.uguz.model.util.PhoneType;
import com.uguz.repository.AdvertisementRepository;
import com.uguz.repository.EducationRepository;
import com.uguz.repository.Repository;
import com.uguz.repository.UserDetailRepository;
import com.uguz.repository.UserRepository;

public class InsertOperation {

	public Repository repository;

	List<User_> users = new ArrayList<User_>();

	List<UserDetail> userDetails = new ArrayList<UserDetail>();

	List<Address> addresses = new ArrayList<Address>();

	List<Education> educations = new ArrayList<Education>();

	List<Advertisement> advertisements = new ArrayList<Advertisement>();

	public void initialOperations() {

		userData();
		userDetailData();
		addressList();
		educationData();
		advertisementData();

		userDetailAddress();
		userDetailPhoneType();
		userAndUserDetail();
		advertsiementUserDetail();;
		advertisementEducation();
	}

	public void insertUserData(UserRepository userRepository) {

		repository = userRepository;

		repository.save(users.get(0));
		repository.save(users.get(1));
		repository.save(users.get(2));
		repository.save(users.get(3));
		

	}

	public void insertUserDetailData(UserDetailRepository userDetailRepository) {

		repository = userDetailRepository;

		repository.save(userDetails.get(0));
		repository.save(userDetails.get(1));
		repository.save(userDetails.get(2));
		repository.save(userDetails.get(3));

	}

	public void insertEducationData(EducationRepository educationRepository) {

		repository = educationRepository;

		repository.save(educations.get(0));
		repository.save(educations.get(1));

	}

	public void insertAdvertisementData(AdvertisementRepository advertisementRepository) {

		repository = advertisementRepository;

		repository.save(advertisements.get(0));
		repository.save(advertisements.get(1));
		repository.save(advertisements.get(2));
		repository.save(advertisements.get(3));

	}

	public void advertisementEducation() {

		advertisements.get(0).getEducations().add(educations.get(0));
		advertisements.get(1).getEducations().add(educations.get(0));
		advertisements.get(2).getEducations().add(educations.get(0));

		advertisements.get(3).getEducations().add(educations.get(1));

	}

	public void userAndUserDetail() {

		users.get(0).setUserDetail(userDetails.get(0));
		users.get(1).setUserDetail(userDetails.get(1));
		users.get(2).setUserDetail(userDetails.get(2));
		users.get(3).setUserDetail(userDetails.get(3));

	}

	public void advertsiementUserDetail() {
		
		advertisements.get(0).setUserDetail(userDetails.get(0));
		advertisements.get(1).setUserDetail(userDetails.get(1));
		advertisements.get(2).setUserDetail(userDetails.get(2));
		advertisements.get(3).setUserDetail(userDetails.get(3));
	
	}

	public void userDetailAddress() {
		// added address
		userDetails.get(0).getAddresses().add(addresses.get(0));
		userDetails.get(1).getAddresses().add(addresses.get(1));
		userDetails.get(2).getAddresses().add(addresses.get(2));
		userDetails.get(3).getAddresses().add(addresses.get(0));

		userDetails.get(0).getAddresses().add(addresses.get(1));
		userDetails.get(1).getAddresses().add(addresses.get(2));
		userDetails.get(2).getAddresses().add(addresses.get(0));

		userDetails.get(3).getAddresses().add(addresses.get(1));

	}

	public void userDetailPhoneType() {
		// added phone numbers
		userDetails.get(0).getPhoneNumbers().put(PhoneType.HOME, "03185556565");
		userDetails.get(0).getPhoneNumbers().put(PhoneType.MOBILE, "05555555555");
		userDetails.get(1).getPhoneNumbers().put(PhoneType.MOBILE, "05645454554");
		userDetails.get(1).getPhoneNumbers().put(PhoneType.HOME, "02165454545");
		userDetails.get(1).getPhoneNumbers().put(PhoneType.WORK, "02165454747");
		userDetails.get(2).getPhoneNumbers().put(PhoneType.MOBILE, "05648585888");
		userDetails.get(3).getPhoneNumbers().put(PhoneType.MOBILE, "05323222222");
	}

	public void userDetailData() {

		UserDetail userDetail1 = new UserDetail("Abdullah", "AAA", new Date());
		UserDetail userDetail2 = new UserDetail("Kemal", "KKK", new Date());
		UserDetail userDetail3 = new UserDetail("Ali", "AAA", new Date());
		UserDetail userDetail4 = new UserDetail("Enes", "EEE", new Date());

		userDetails.add(userDetail1);
		userDetails.add(userDetail2);
		userDetails.add(userDetail3);
		userDetails.add(userDetail4);

	}

	public void userData() {

		User_ user1 = new User_("Abdullah123", "12345", "abdullah123@gmail.com", new Date());
		User_ user2 = new User_("Kemal123", "12345", "kemal123@gmail.com", new Date());
		User_ user3 = new User_("Ali123", "12345", "ali123@gmail.com", new Date());
		User_ user4 = new User_("Enes123", "12345", "enes123@gmail.com", new Date());
	
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);

	}

	public void advertisementData() {

		Advertisement advertisement1 = new Advertisement("Computer Engineer", "Software Developer", "Java");
		Advertisement advertisement2 = new Advertisement("Computer Engineer", "Form Developer", "C#");
		Advertisement advertisement3 = new Advertisement("Computer Engineer", "AI Developer", "Python");
		Advertisement advertisement4 = new Advertisement("Industrial Engineer", "Database ", "TSQL");

		advertisements.add(advertisement1);
		advertisements.add(advertisement2);
		advertisements.add(advertisement3);
		advertisements.add(advertisement4);

	}

	public void educationData() {

		Education education1 = new Education("Computer Engineer");
		Education education2 = new Education("Industrial Engineer");

		educations.add(education1);
		educations.add(education2);

	}

	public void addressList() {

		Address address1 = new Address("Malazgirt", "Yesilyurt", 70800, "Karaman");
		Address address2 = new Address("Kanyon", "Mevlana", 38800, "Kayseri");
		Address address3 = new Address("Gazi", "Yeniyurt", 52000, "Ordu");

		addresses.add(address1);
		addresses.add(address2);
		addresses.add(address3);

	}

}
