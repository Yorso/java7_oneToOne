package com.jorge.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

// INVERSED END side

@Entity
public class Passport {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="passport_number")
	private String passportNumber;
	
	@OneToOne(mappedBy="passport") // 'passport' is the name of the private attribute in Customer.java class => private Passport passport; 
							       // 'mappedBy' attribute declares this class as not responsible for the relationship => inversed end
	private Customer customer;
	
	public Passport() {}
	
	public Passport(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Passport [id=" + id + ", passportNumber=" + passportNumber + ", customer=" + customer + "]";
	}
	
}
