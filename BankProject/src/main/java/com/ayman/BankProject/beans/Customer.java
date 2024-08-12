package com.ayman.BankProject.beans;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Integer customerId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "city")
	private String city;

	@Column(name = "street")
	private String street;

	@Column(name = "username")
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "birthday")
	private Date birthDay;
	
	
	@OneToMany(mappedBy = "customer")
	private List<Account> accounts;
	
	
	@OneToMany(mappedBy = "customer")
	private List<Loan> loans;
	
	
	@OneToMany(mappedBy = "customer")
	private List<EmailNotification> emailNotifications;

	public Customer() {

	}

	public Customer(String firstName, String lastName, String city, String street, String userName, String password,
			Date birthDay) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.street = street;
		this.userName = userName;
		this.password = password;
		this.birthDay = birthDay;
	}

	public Integer getCustomeId() {
		return customerId;
	}

	public void setCustomeId(Integer customeId) {
		this.customerId = customeId;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
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

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	@Override
	public String toString() {
		return "Customer [customeId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", city="
				+ city + ", street=" + street + ", userName=" + userName + ", password=" + password + ", birthDay="
				+ birthDay + "]";
	}

}
