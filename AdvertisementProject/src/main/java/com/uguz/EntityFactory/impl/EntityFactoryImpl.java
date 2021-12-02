package com.uguz.EntityFactory.impl;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.uguz.EntityFactory.EntityFactory;

public class EntityFactoryImpl implements EntityFactory {

	@Override
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("AdvertisementProject").createEntityManager();
	}

}
