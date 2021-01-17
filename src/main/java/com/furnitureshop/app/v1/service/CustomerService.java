package com.furnitureshop.app.v1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furnitureshop.app.v1.entity.CustomerEntity;
import com.furnitureshop.app.v1.model.CustomerDto;
import com.furnitureshop.app.v1.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public CustomerEntity getCustomer(Long id) {
		return customerRepository.findById(id).get(); // Optional<Customer> needed if not to use get()
	}

	public List<CustomerEntity> getAllCustomers() {
		return customerRepository.findAll();
	}

	public CustomerEntity createUser(CustomerEntity customer) {
		return customerRepository.save(customer);
		
	}

	public CustomerEntity findCustomerByEmail(String email) {
		return customerRepository.findByEmail(email);
		
	}

	public CustomerEntity updateCustomer(Long id, CustomerDto customerDto) {
		if( customerRepository.findById(id).isPresent()) {
			System.out.println("Customer found");
		CustomerEntity customer = customerRepository.findById(id).get();
  		customer.setFirstName(customerDto.getFirstName());
		customer.setLastName(customerDto.getLastName());
		customer.setPhoneNumber(customerDto.getPhoneNumber()); // add more fields
		
		CustomerEntity updatedCustomer = customerRepository.save(customer);
		return updatedCustomer;
			
		} else {
			return null;

		}
		
	}

	public void deleteCustomer(Long id) {
		customerRepository.deleteById(id);
		
	}
	

}
