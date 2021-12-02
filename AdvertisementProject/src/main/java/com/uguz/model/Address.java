package com.uguz.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	private String street;
	
	private String neighbourhood;
	
	private int postaCode;
	
	private String city;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(String street, String neighbourhood, int postaCode, String city) {
		this.street = street;
		this.neighbourhood = neighbourhood;
		this.postaCode = postaCode;
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getRoad() {
		return neighbourhood;
	}

	public void setRoad(String neighbourhood) {
		this.neighbourhood = neighbourhood;
	}

	public int getPostaCode() {
		return postaCode;
	}

	public void setPostaCode(int postaCode) {
		this.postaCode = postaCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", neighbourhood=" + neighbourhood + ", postaCode=" + postaCode + ", city=" + city + "]";
	}
	

}
