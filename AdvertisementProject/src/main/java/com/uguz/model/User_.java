package com.uguz.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.uguz.model.entity.EntityClass;

@Entity
@NamedQueries({
	@NamedQuery(name="User_.findById",query = "SELECT u FROM User_ u LEFT JOIN FETCH u.userDetail WHERE u.id=:userId"),
	@NamedQuery(name="User_.findByUserName",query="SELECT u FROM User_ u  WHERE u.userName=:userName"),
	@NamedQuery(name="User_.findWithUserDetailByUserName",query = "SELECT u FROM User_ u LEFT JOIN FETCH u.userDetail WHERE u.userName=:userName"),
	@NamedQuery(name="User_.findUsers",query ="SELECT u FROM User_ u "),
	@NamedQuery(name="User_.findUserCount",query ="SELECT COUNT(u) FROM User_ u"),
	@NamedQuery(name="User_.findUserInfoByUserName"
		,query ="SELECT new com.uguz.model.UserInfo(u.userName,u.email,u.userDetail.firstName,u.userDetail.lastName,u.userDetail.birthOfDate) "
				+ "FROM User_ u WHERE u.userName=:userName")
})
public class User_ implements Serializable,EntityClass{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String userName;
	
	@Column
	private String password;
	
	@Column
	private String email;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	@OneToOne(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
	@JoinColumn(name="userDetailId")
	private UserDetail userDetail;

	public User_() {
		// TODO Auto-generated constructor stub
	}

	public User_(String userName, String password,String email,Date createDate) {
		this.userName = userName;
		this.password = password;
		this.email=email;
		this.createDate = createDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User_ [id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", createDate=" + createDate + ", userDetail=" + userDetail + "]";
	}

	
	


}
