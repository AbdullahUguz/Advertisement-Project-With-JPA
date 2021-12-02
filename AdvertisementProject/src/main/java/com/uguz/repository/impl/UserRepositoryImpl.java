package com.uguz.repository.impl;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;


import com.uguz.model.User_;
import com.uguz.model.entity.EntityClass;
import com.uguz.model.UserInfo;
import com.uguz.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {


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

				manager.refresh(entity);
			} else {

				manager.remove(this.findById(((User_) entity).getId()));
			}

		} catch (Exception e) {

			System.out.println("ERROR : " + e);
			return false;

		}

		return true;
	}

	@Override
	public User_ findById(int id) {

		User_ user = null;

		try {

			TypedQuery<User_> typedQuery = manager.createNamedQuery("User.findById", User_.class);
			typedQuery.setParameter("userId", id);
			user = typedQuery.getSingleResult();

		} catch (NoResultException e) {
			System.out.println("ERROR : " + e);
		}

		return user;
	}

	@Override
	public User_ findByUserName(String userName) {

		User_ user = null;

		try {

			TypedQuery<User_> typedQuery = manager.createNamedQuery("User.findByUserName", User_.class);
			typedQuery.setParameter("userName", userName);
			user = typedQuery.getSingleResult();

		} catch (NoResultException e) {
			System.out.println("ERROR : " + e);
		}

		return user;
	}

	@Override
	public User_ findWithUserDetailByUserName(String userName) {

		User_ user = null;

		try {

			TypedQuery<User_> typedQuery = manager.createNamedQuery("User.findWithUserDetailByUserName",
					User_.class);
			typedQuery.setParameter("userName", userName);
			user = typedQuery.getSingleResult();

		} catch (NoResultException e) {
			System.out.println("ERROR : " + e);
		}

		return user;
	}

	@Override
	public List<User_> findUsers() {

		List<User_> users = null;

		try {

			TypedQuery<User_> typedQuery = manager.createNamedQuery("User.findUsers", User_.class);
			users = typedQuery.getResultList();

		} catch (NoResultException e) {
			System.out.println("ERROR : " + e);
		}
		return users;
	}

	@Override
	public List<User_> findUsers(int firstResult, int maxResult) {

		List<User_> users = null;
		try {
			TypedQuery<User_> typedQuery = manager.createNamedQuery("User.findUsers", User_.class);
			typedQuery.setFirstResult(firstResult);
			typedQuery.setMaxResults(maxResult);

			users = typedQuery.getResultList();

		} catch (NoResultException e) {
			System.out.println("ERROR : " + e);
		}

		return users;
	}

	@Override
	public int findUserCount() {

		Long count = null;

		try {
			TypedQuery<Long> typedQuery = manager.createNamedQuery("User.findUserCount", Long.class);
			count = typedQuery.getSingleResult();

		} catch (NoResultException e) {
			System.out.println("ERROR : " + e);
		}

		return count.intValue();
	}

	@Override
	public UserInfo findUserInfoByUserName(String userName) {

		UserInfo userInfo = null;

		try {
			TypedQuery<UserInfo> typedQuery=manager.createNamedQuery("User.findUserInfoByUserName", UserInfo.class);
			typedQuery.setParameter("userName", userName);
			userInfo=typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("ERROR : " + e);
		}

		return userInfo;
	}

}
