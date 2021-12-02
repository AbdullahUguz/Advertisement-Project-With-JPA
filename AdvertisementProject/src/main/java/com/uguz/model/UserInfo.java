package com.uguz.model;

import java.util.Date;

public class UserInfo {

	private String userName;

	private String email;

	private String firstName;

	private String lastName;

	private Date birthOfDate;

	public UserInfo() {
		// TODO Auto-generated constructor stub
	}

	public UserInfo(String userName, String email, String firstName, String lastName, Date birthOfDate) {

		this.userName = userName;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthOfDate = birthOfDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthOfDate() {
		return birthOfDate;
	}

	public void setBirthOfDate(Date birthOfDate) {
		this.birthOfDate = birthOfDate;
	}

	@Override
	public String toString() {
		return "UserInfo [userName=" + userName + ", email=" + email + ", firstName=" + firstName + ", lastName="
				+ lastName + ", birthOfDate=" + birthOfDate + "]";
	}

}
