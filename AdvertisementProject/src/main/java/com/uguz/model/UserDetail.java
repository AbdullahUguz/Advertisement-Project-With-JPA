package com.uguz.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.uguz.model.entity.EntityClass;
import com.uguz.model.util.PhoneType;

@Entity
@NamedQueries({
	@NamedQuery(name="UserDetail.findById",query="SELECT ud FROM UserDetail ud WHERE ud.id=:userDetailId"),
	@NamedQuery(name="UserDetail.findByUserName",query = "SELECT ud FROM UserDetail ud  WHERE ud.user.userName=:userName"),
	@NamedQuery(name="UserDetail.findWithAddressByUserName",
			query="SELECT ud FROM UserDetail ud LEFT JOIN FETCH ud.addresses WHERE ud.user.userName=:userName"),
	@NamedQuery(name="UserDetail.findWithAdvertisementByUserName",
			query = "SELECT ud FROM UserDetail ud LEFT JOIN FETCH ud.advertisements WHERE ud.user.userName=:userName")
})
public class UserDetail implements Serializable,EntityClass{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date birthOfDate;
	
	@ElementCollection
	@JoinTable(name="user_detail_phone_number",joinColumns = @JoinColumn(name="userDetailId"))
	@MapKeyColumn(name="phoneType")
	@MapKeyEnumerated(EnumType.STRING)
	@Column(name="phoneNumber")
	private Map<PhoneType,String> phoneNumbers=new HashMap<PhoneType, String>();
	
	@ElementCollection(fetch = FetchType.LAZY)
	@JoinTable(name="user_detail_address",joinColumns = @JoinColumn(name="userDetailId"))
	private List<Address> addresses=new ArrayList<Address>();
	
	@OneToMany(mappedBy = "userDetail",fetch = FetchType.LAZY)
	private List<Advertisement> advertisements=new ArrayList<Advertisement>();
	
	@OneToOne(mappedBy ="userDetail",fetch = FetchType.EAGER)
	private User_ user;
	
	public UserDetail() {
		// TODO Auto-generated constructor stub
	}

	public UserDetail(String firstName, String lastName, Date birthOfDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthOfDate = birthOfDate;
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

	public Map<PhoneType, String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Map<PhoneType, String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Advertisement> getAdvertisements() {
		return advertisements;
	}

	public void setAdvertisements(List<Advertisement> advertisements) {
		this.advertisements = advertisements;
	}

	public User_ getUser() {
		return user;
	}

	public void setUser(User_ user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "UserDetail [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthOfDate="
				+ birthOfDate + ", phoneNumbers=" + phoneNumbers + ", addresses=" + addresses + "]";
	}

	

	
	
	
	
}
