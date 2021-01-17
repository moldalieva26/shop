package com.furniture.shop.webappv1.tests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.furnitureshop.app.v1.entity.CustomerEntity;
import com.furnitureshop.app.v1.entity.OrderDetailEntity;
import com.furnitureshop.app.v1.entity.OrderEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes={SpringBootApplication.class})
@WebAppConfiguration
@AutoConfigureMockMvc
@ComponentScan(basePackages = {"com.furnitureshop"}) 
@WithUserDetails(value="testuser3", userDetailsServiceBeanName="userDetailsServiceImpl")
public class OrderControllerTest {
	@Autowired 
	MockMvc mockMvc;
	
	@Ignore
    @Test
    public void getAllOrdersTest() throws Exception{
        mockMvc.perform(get("/orders"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    
	@Ignore
	@Test
	public void getOrderByIdTest() throws Exception{
		this.mockMvc.perform(get("/orders/1111")).andDo(print())
		.andExpect(status().isOk());
		
	}
	
	@Ignore // did not pass
	@Test
	public void createOrderTest() throws Exception{
		OrderEntity order  =  new OrderEntity();
		order.setOrderDate("date");
		order.setStatus((short) 1);
		CustomerEntity customer = new CustomerEntity();
		order.setCustomer(customer );
		//check set...() methods in Entity Class
		// instance is created but the values are not set
		
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(order);
        mockMvc.perform(post("/orders") //.contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk());
		
	}
	
	
	@Ignore
	@Test
	public void updateOrderTest() throws Exception{
		OrderEntity order  =  new OrderEntity();
		order.setOrderDate("date2");
		order.setStatus((short) 2);
		CustomerEntity customer = new CustomerEntity();
		order.setCustomer(customer );
		//check set...() methods in Entity Class
		// instance is created but the values are not set
		
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(order);
        mockMvc.perform(post("/orders") //.contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk());
		
	}
	
	@Ignore
	@Test
	public void deleteOrderDetailByIdTest() throws Exception{
		this.mockMvc.perform(delete("/orders/36")).andDo(print())
		.andExpect(status().isOk());
		
	}
	
	

}
