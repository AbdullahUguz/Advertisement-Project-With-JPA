package com.uguz.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import com.uguz.model.entity.EntityClass;


@Entity
@NamedQueries({
	@NamedQuery(name="Education.findEducations",query = "SELECT e FROM Education e"),
	@NamedQuery(name="Education.findById",query = "SELECT e FROM Education e WHERE e.id=:educationId"),
	@NamedQuery(name="Education.findWithAdvertisementById",query = "SELECT e FROM Education e LEFT JOIN FETCH e.advertisements WHERE e.id=:educationId")
})
public class Education implements Serializable,EntityClass{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String educationName;
	
	@ManyToMany(mappedBy = "educations",fetch = FetchType.LAZY)
	private List<Advertisement> advertisements;
	
	public Education() {
		// TODO Auto-generated constructor stub
	}

	public Education(String educationName) {
		super();
		this.educationName = educationName;
	}

	public String getEducationName() {
		return educationName;
	}

	public void setEducationName(String educationName) {
		this.educationName = educationName;
	}

	public List<Advertisement> getAdvertisements() {
		return advertisements;
	}

	public void setAdvertisements(List<Advertisement> advertisements) {
		this.advertisements = advertisements;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Education [id=" + id + ", educationName=" + educationName + ", advertisements=" + advertisements + "]";
	}

	
	
	
	
}
