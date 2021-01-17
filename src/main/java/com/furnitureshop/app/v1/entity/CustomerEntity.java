package com.furnitureshop.app.v1.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="customer")
public class CustomerEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone_number")
	private String phoneNumber; 
	
	@Column(name="address_line1")
	private String addressLine1;
	
	@Column(name="address_line2")
	private String addressLine2;
	
	@Column(name="city")
	private String city;
	
	@Column(name="province")
	private String province;
	
	@Column(name="country")
	private String country;
	
	@Column(name="postal_code")
	private Integer postalCode; 
	
    @OneToOne (mappedBy="customerId") //non owning side // customerId from Cart.Class
    private CartEntity cart; // gives error, correct and uncomment
    
    // password 
	 

	
	// if i use biderectorial mapping
	//@OneToMany(mappedBy = "customers", cascade = CascadeType.ALL, fetch=FetchType.LAZY)  // cascade = CascadeType.ALL, fetch=FetchType.LAZY ???
	//@JoinColumn(name="customer_id")
	//private Set<Order> orders; // Set? 
	

	
	public CustomerEntity() {
		
	}



	public CustomerEntity(Long id, String firstName, String lastName, String email, String phoneNumber, String addressLine1,
			String addressLine2, String city, String province, String country, Integer postalCode, CartEntity cart) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.province = province;
		this.country = country;
		this.postalCode = postalCode;
		this.cart = cart;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
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



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public String getAddressLine1() {
		return addressLine1;
	}



	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}



	public String getAddressLine2() {
		return addressLine2;
	}



	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getProvince() {
		return province;
	}



	public void setProvince(String province) {
		this.province = province;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public Integer getPostalCode() {
		return postalCode;
	}



	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}



	public CartEntity getCart() {
		return cart;
	}



	public void setCart(CartEntity cart) {
		this.cart = cart;
	}
	
	


	
/**

	public Set<Order> getOrders() {
		return orders;
	}


	public void setOrders(Set<Order> orders) {
		this.orders = orders;
		
		for(Order o: orders) {
			o.setCustomers(this);
		}
	}
*/


	
	
		

}
