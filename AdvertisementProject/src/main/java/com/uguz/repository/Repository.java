package com.uguz.repository;

import javax.persistence.EntityManager;

import com.uguz.EntityFactory.EntityFactory;
import com.uguz.EntityFactory.impl.EntityFactoryImpl;
import com.uguz.model.entity.EntityClass;

public interface Repository {

	EntityFactory factory = new EntityFactoryImpl();
	
	EntityManager manager=factory.getEntityManager();

	boolean save(EntityClass entity);

	boolean update(EntityClass entity);

	boolean remove(EntityClass entity);

}
