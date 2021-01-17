package com.furniture.shop.webappv1.tests;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;

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

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes={SpringBootApplication.class})
@WebAppConfiguration
@AutoConfigureMockMvc
@ComponentScan(basePackages = {"com.furnitureshop"}) 
@WithUserDetails(value="testuser3", userDetailsServiceBeanName="userDetailsServiceImpl")
public class OrderDetailControllerTest {
	
	@Autowired 
	MockMvc mockMvc;
	
	@Ignore
    @Test
    public void getAllOrderDetailTest() throws Exception{
        mockMvc.perform(get("/orderdetails"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    
	@Ignore
	@Test
	public void getOrderDetailByIdTest() throws Exception{
		this.mockMvc.perform(get("/orderdetails/1111")).andDo(print())
		.andExpect(status().isOk());
		
	}
	
	@Ignore
	@Test
	public void createOrderDetailTest() throws Exception{
		OrderDetailEntity orderDetail  =  new OrderDetailEntity();
		orderDetail.setQuantity(12L);
		orderDetail.setSubtotal(50F);
		//check set...() methods in Entity Class
		// instance is created but the values are not set
		
		
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(orderDetail);
        mockMvc.perform(post("/orderdetails") //.contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk());
		
	}
	
	
	@Ignore
	@Test
	public void updateOrderDetailTest() throws Exception{
		OrderDetailEntity orderDetail  =  new OrderDetailEntity();
		orderDetail.setQuantity(1L);
		orderDetail.setSubtotal(5F);
		//check set...() methods in Entity Class
		
		
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(orderDetail);
        mockMvc.perform(put("/orderdetails/36").contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk());
		
	}
	
	@Ignore
	@Test
	public void deleteOrderDetailByIdTest() throws Exception{
		this.mockMvc.perform(delete("/orderdetails/36")).andDo(print())
		.andExpect(status().isOk());
		
	}

}
