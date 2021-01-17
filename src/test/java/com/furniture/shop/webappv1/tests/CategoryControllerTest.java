package com.furniture.shop.webappv1.tests;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
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
import com.furnitureshop.app.v1.entity.CategoryEntity;
import com.furnitureshop.app.v1.entity.CustomerEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes={SpringBootApplication.class})
@WebAppConfiguration
@AutoConfigureMockMvc
@ComponentScan(basePackages = {"com.furnitureshop"}) 
@WithUserDetails(value="testuser3", userDetailsServiceBeanName="userDetailsServiceImpl")
public class CategoryControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Ignore
	@Test
	public void getAllCategoriesTest() throws Exception{
        mockMvc.perform(get("/categories"))
        .andDo(print())
        .andExpect(status().isOk());
	}
	
	@Ignore
	@Test
	public void getCategoriesByIdTest() throws Exception{
        mockMvc.perform(get("/categories/26"))
        .andDo(print())
        .andExpect(status().isOk());
	}
	
	@Ignore
	@Test
	public void createCustomerControllerTest() throws Exception{
		CategoryEntity category  =  new CategoryEntity();
		category.setCategoryName("Plastic");
		category.setSubCategoryName("Semi gloss");
				
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(category);
        mockMvc.perform(post("/categories").contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
        		.andExpect(status().isOk());
	}
	
	@Ignore
	@Test
	public void updateCustomerControllerTest() throws Exception{
		CategoryEntity category  =  new CategoryEntity();
		category.setCategoryName("Plastic");
		category.setSubCategoryName("Semi gloss");
				
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(category);
        mockMvc.perform(put("/categories/26").contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
        		.andExpect(status().isOk());
	}
	
	//@Ignore
	@Test
	public void deleteCategoriesByIdTest() throws Exception{
        mockMvc.perform(get("/categories/26"))
        .andDo(print())
        .andExpect(status().isOk());
	}
	
	
}
