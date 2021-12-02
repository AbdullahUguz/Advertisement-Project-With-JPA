package com.uguz.repository.impl;


import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;


import com.uguz.model.UserDetail;
import com.uguz.model.entity.EntityClass;
import com.uguz.repository.UserDetailRepository;

public class UserDetailRepositoryImpl implements UserDetailRepository {

	
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

				manager.remove(this.findById(((UserDetail) entity).getId()));
			}

		} catch (Exception e) {

			System.out.println("ERROR : " + e);
			return false;

		}

		return true;
	}

	@Override
	public UserDetail findById(int id) {

		UserDetail userDetail = null;

		try {

			TypedQuery<UserDetail> typedQuery = manager.createNamedQuery("UserDetail.findById", UserDetail.class);
			typedQuery.setParameter("userDetailId", id);
			userDetail = typedQuery.getSingleResult();

		} catch (NoResultException e) {
			System.out.println("ERROR : " + e);

		}

		return userDetail;
	}

	@Override
	public UserDetail findByUserName(String userName) {

		UserDetail userDetail = null;

		try {

			TypedQuery<UserDetail> typedQuery = manager.createNamedQuery("UserDetail.findByUserName",
					UserDetail.class);
			typedQuery.setParameter("userName", userName);

		} catch (NoResultException e) {
			System.out.println("ERROR : " + e);
		}

		return userDetail;
	}

	@Override
	public UserDetail findWithAddressByUserName(String userName) {

		UserDetail userDetail = null;

		try {

			TypedQuery<UserDetail> typedQuery = manager.createNamedQuery("UserDetail.findWithAddressByUserName",
					UserDetail.class);
			typedQuery.setParameter("userName", userName);

		} catch (NoResultException e) {
			System.out.println("ERROR : " + e);
		}

		return userDetail;
	}

	@Override
	public UserDetail findWithAdvertisementByUserName(String userName) {
		
		UserDetail userDetail = null;

		try {

			TypedQuery<UserDetail> typedQuery = manager.createNamedQuery("UserDetail.findWithAdvertisementByUserName",
					UserDetail.class);
			typedQuery.setParameter("userName", userName);

		} catch (NoResultException e) {
			System.out.println("ERROR : " + e);
		}

		return userDetail;
	}

}
