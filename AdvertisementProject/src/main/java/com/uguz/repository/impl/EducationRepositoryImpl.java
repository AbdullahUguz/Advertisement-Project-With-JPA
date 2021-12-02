package com.uguz.repository.impl;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;


import com.uguz.model.Education;
import com.uguz.model.entity.EntityClass;
import com.uguz.repository.EducationRepository;



public class EducationRepositoryImpl implements EducationRepository {


//	private EntityManager manager =factory.getEntityManager();
	private EntityTransaction transaction = manager.getTransaction();

	@Override
	public boolean save(EntityClass entity) {
		try {

			this.transaction.begin();

			manager.persist(entity);

			this.transaction.commit();

		} catch (Exception e) {

			System.out.println("ERROR : " + e);

			try {
				this.transaction.rollback();

			} catch (RollbackException e2) {

				System.out.println("ERROR : " + e2);
			}

			return false;
		} 
		
		return true;
	}

	@Override
	public boolean update(EntityClass entity) {
		try {

			this.transaction.begin();

			manager.merge(entity);

			manager.flush();

			this.transaction.commit();

		} catch (Exception e) {

			System.out.println("ERROR : " + e);

			try {

				this.transaction.rollback();

			} catch (RollbackException e2) {
				System.out.println("ERROR : " + e2);
			}

			return false;

		} 
		
		return true;
	}

	@Override
	public boolean remove(EntityClass entity) {

		try {

			if (manager.contains(entity)) {

				manager.refresh(entity);
			} else {

				manager.remove(this.findById(((Education) entity).getId()));
			}

		} catch (Exception e) {

			System.out.println("ERROR : " + e);
			return false;

		}
		
		return true;
	}

	@Override
	public List<Education> findEducations() {

		List<Education> educations = null;

		try {

			TypedQuery<Education> typedQuery = manager.createNamedQuery("Education.findEducations",
					Education.class);

			educations = typedQuery.getResultList();

		} catch (NoResultException e) {

			System.out.println("ERROR : " + e);

		}

		return educations;
	}

	@Override
	public Education findById(int id) {

		Education education = null;

		try {

			TypedQuery<Education> typedQuery = manager.createNamedQuery("Education.findById", Education.class);
			typedQuery.setParameter("educationId", id);
			education = typedQuery.getSingleResult();

		} catch (NoResultException e) {

			System.out.println("ERROR : " + e);
		}

		return education;
	}

	@Override
	public Education findWithAdvertisementById(int id) {

		Education education = null;

		try {
			
			TypedQuery<Education> typedQuery=manager.createNamedQuery("Education.findWithAdvertisementById", Education.class);
			typedQuery.setParameter("educationId", id);
			
			
		} catch (NoResultException e) {

			System.out.println("ERROR : " + e);
		}
		
		return education;
	}

}
