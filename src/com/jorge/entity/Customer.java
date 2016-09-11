package com.jorge.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

//OWNER of this bidirectional relationship
//The owner of the relationship is responsible for the association column(s) update

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	//@Column(name="name")
	private String name;
	
	@OneToOne(cascade={CascadeType.PERSIST})
	@JoinColumn(name="passprot_id", unique=true) // passport_id is the name of the field in passport table, linked to id field in passport table
    									         // You say with @JoinColumn annotation that this class is the owner of the relationship
	private Passport passport;
	
	public Customer() {}
	
	public Customer(String name, Passport passport) {
		this.name = name;
		this.passport = passport;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", passport=" + passport + "]";
	}
	
}
