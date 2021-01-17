package com.furniture.shop.webappv1.tests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.furnitureshop.app.v1.entity.CustomerEntity;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;

//perfecto!
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes={SpringBootApplication.class})
@WebAppConfiguration
@AutoConfigureMockMvc
@ComponentScan(basePackages = {"com.furnitureshop"}) // bez nego vydaet 404 (ne vidit controllery) 
@WithUserDetails(value="testuser3", userDetailsServiceBeanName="userDetailsServiceImpl") //value="customUsername", userDetailsServiceBeanName="myUserDetailsService")
public class CustomerControllerTest {
	@Autowired
    private MockMvc mockMvc;

	@Ignore
    @Test
    public void getAllCustomers() throws Exception{
        mockMvc.perform(get("/customers/all"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    
	@Ignore
	@Test
	public void getCustomerByIdTest() throws Exception{
		this.mockMvc.perform(get("/customers/1")).andDo(print())
		.andExpect(status().isOk());
		
	}
	
	@Ignore
	@Test
	public void getCustomerByEmail() throws Exception{
		String email = "test@test.com";
		this.mockMvc.perform(get("/customers").param("email", email)).andDo(print())
		.andExpect(status().isOk());

	}
	
	@Ignore
	@Test
	public void createCustomerControllerTest() throws Exception{
		CustomerEntity customer  =  new CustomerEntity();
		customer.setFirstName("Titan");
		customer.setLastName("Veron");
		customer.setAddressLine1("119 Lera Rd");
		customer.setAddressLine2("NYC");
		customer.setEmail("titan@test.com");
				
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(customer);
        mockMvc.perform(post("/customers").contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
        		.andExpect(status().isOk());
	}
	
	@Ignore
	@Test
	public void updateCustomerControllerTest() throws Exception{
		CustomerEntity customer  =  new CustomerEntity();
		customer.setFirstName("Titan2");
		customer.setLastName("Veron2");
		customer.setAddressLine1("119 Lera Rd");
		customer.setAddressLine2("NYC");
		customer.setEmail("titan@test.com");
		
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(customer);
        mockMvc.perform(put("/customers/34") //.contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk());
		
	}
	
	@Ignore
	@Test
	public void deleteCustomerControllerTest() throws Exception{
		this.mockMvc.perform(delete("/customers/34")).andDo(print())
		.andExpect(status().isOk());
	}
 

}
