package com.dulich4phuong.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Indexed;

@Entity
@Table(name = "cust")
@Indexed
@XmlRootElement
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6054949809878599960L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @DocumentId
	private Long id;
	private String firstname;
	private String lastname;
	private String address;
	private String phone;
	
	@OneToOne
    @JoinColumn(name="cat_id")  
	private CustomerCategory category;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public CustomerCategory getCategory() {
		return category;
	}

	public void setCategory(CustomerCategory category) {
		this.category = category;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}
