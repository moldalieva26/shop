package com.furnitureshop.app.v1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furnitureshop.app.v1.entity.CustomerEntity;
import com.furnitureshop.app.v1.model.CustomerDto;
import com.furnitureshop.app.v1.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private  CustomerService customerService; 

	@GetMapping("/all")  // issue with id=31
	public List<CustomerEntity> getCutomers(){
		return customerService.getAllCustomers();
	}
	
	@GetMapping(path="/{id}")
	public CustomerEntity getCustomer(@PathVariable Long id) {
		return customerService.getCustomer(id); 
	}
	
	@GetMapping()  
	public CustomerEntity getCustomerByEmail(@RequestParam(value="email") String email) {
		return customerService.findCustomerByEmail(email);
	}

	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE) 
	public CustomerEntity createCustomer(@RequestBody CustomerEntity customer) {
		return customerService.createUser(customer);
	}

	
	@PutMapping(path="/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE) 
	public CustomerEntity updateCustomer(@RequestBody CustomerDto customerDto, @PathVariable Long id) {
		return customerService.updateCustomer(id, customerDto);	
	}

	@DeleteMapping(path="/{id}") 
	public @ResponseBody void deleteCustomer(@PathVariable Long id) {
		customerService.deleteCustomer(id);		
	}
	
	
	
	

}
