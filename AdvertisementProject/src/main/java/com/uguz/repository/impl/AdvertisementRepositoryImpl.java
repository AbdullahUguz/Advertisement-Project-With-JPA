package com.uguz.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import com.uguz.model.Advertisement;
import com.uguz.model.entity.EntityClass;
import com.uguz.repository.AdvertisementRepository;


public class AdvertisementRepositoryImpl  implements AdvertisementRepository {

//	private EntityManager manager = factory.getEntityManager();
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

				manager.remove(entity);
			} else {
				manager.remove(this.findById(((Advertisement) entity).getId()));
			}

		} catch (Exception e) {

			System.out.println("ERROR : " + e);
			return false;

		}

		return true;
	}

	@Override
	public Advertisement findById(final int id) {

		Advertisement advertisement = null;

		try {

			TypedQuery<Advertisement> typedQuery = manager.createNamedQuery("Advertisement.findById",
					Advertisement.class);
			typedQuery.setParameter("advertisementId", id);
			advertisement = typedQuery.getSingleResult();

		} catch (NoResultException e) {

			System.out.println("ERROR : " + e);

		}
		
		return advertisement;
	}

	@Override
	public List<Advertisement> findByUserName(final String userName) {

		List<Advertisement> advertisements = null;

		try {

			TypedQuery<Advertisement> typedQuery = manager.createNamedQuery("Advertisement.findByUserName",
					Advertisement.class);
			typedQuery.setParameter("userName", userName);
			advertisements = typedQuery.getResultList();

		} catch (NoResultException e) {

			System.out.println("ERROR : " + e);
		}

		return advertisements;
	}

	@Override
	public List<Advertisement> findAdvertisements() {

		List<Advertisement> advertisements = null;

		try {

			TypedQuery<Advertisement> typedQuery = manager.createNamedQuery("Advertisement.findAdvertisements",
					Advertisement.class);
			advertisements = typedQuery.getResultList();

		} catch (NoResultException e) {

			System.out.println("ERROR : " + e);
		}

		return advertisements;
	}

	@Override
	public List<Advertisement> findAdvertisementEntities(int firstResult, int maxResult) {

		List<Advertisement> advertisements = null;

		try {

			TypedQuery<Advertisement> typedQuery = manager.createNamedQuery("Advertisement.findAdvertisements",
					Advertisement.class);

			typedQuery.setFirstResult(firstResult);
			typedQuery.setMaxResults(maxResult);

			advertisements = typedQuery.getResultList();

		} catch (NoResultException e) {

			System.out.println("ERROR : " + e);
		}

		return advertisements;
	}

	

}
