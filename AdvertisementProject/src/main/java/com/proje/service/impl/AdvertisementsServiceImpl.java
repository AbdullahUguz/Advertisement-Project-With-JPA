package com.proje.service.impl;

import java.util.List;

import com.proje.service.AdvertisementService;
import com.uguz.model.Advertisement;
import com.uguz.repository.AdvertisementRepository;
import com.uguz.repository.impl.AdvertisementRepositoryImpl;

public class AdvertisementsServiceImpl implements AdvertisementService{
	
	private AdvertisementRepository advertisementRepository=new AdvertisementRepositoryImpl();

	@Override
	public boolean save(Advertisement advertisement) {
		
		return this.advertisementRepository.save(advertisement);
	}

	@Override
	public boolean update(Advertisement advertisement) {
	
		return this.advertisementRepository.update(advertisement);
	}

	@Override
	public boolean remove(Advertisement advertisement) {
		
		return this.advertisementRepository.remove(advertisement);
	}

	@Override
	public Advertisement findById(int id) {
		
		return this.advertisementRepository.findById(id);
	}

	@Override
	public List<Advertisement> findByUserName(String userName) {
		
		return this.advertisementRepository.findByUserName(userName);
	}

	@Override
	public List<Advertisement> findAdvertisements() {
		
		return this.advertisementRepository.findAdvertisements();
	}

	@Override
	public List<Advertisement> findAdvertisementEntities(int firstResult, int maxResult) {
		
		return this.advertisementRepository.findAdvertisementEntities(firstResult, maxResult);
	}
	
	

}
