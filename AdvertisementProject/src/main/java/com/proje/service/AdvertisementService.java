package com.proje.service;

import java.util.List;

import com.uguz.model.Advertisement;

public interface AdvertisementService {

	boolean save(Advertisement advertisement);

	boolean update(Advertisement advertisement);

	boolean remove(Advertisement advertisement);

	Advertisement findById(int id);

	List<Advertisement> findByUserName(String userName);

	List<Advertisement> findAdvertisements();

	List<Advertisement> findAdvertisementEntities(int firstResult, int maxResult);

}
