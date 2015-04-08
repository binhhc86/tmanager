package com.dulich4phuong.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

@Entity
@Table(name = "cust_cat")
@Indexed
@XmlRootElement
public class CustomerCategory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2146218631676754442L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @DocumentId
    @Column(name="cat_id")
	private Long id;

	@Column(nullable = false, length = 50, unique = true)
    @Field
	private String category;
	
	public CustomerCategory() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
