package com.furniture.shop.webappv1.tests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
import com.furnitureshop.app.v1.entity.OrderDetailEntity;
import com.furnitureshop.app.v1.entity.ProductCategoryEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes={SpringBootApplication.class})
@WebAppConfiguration
@AutoConfigureMockMvc
@ComponentScan(basePackages = {"com.furnitureshop"}) 
@WithUserDetails(value="testuser3", userDetailsServiceBeanName="userDetailsServiceImpl")
public class ProductCategoryControllerTest {
	

	@Autowired 
	MockMvc mockMvc;
	
	@Ignore
    @Test
    public void getAllProductCategoriesTest() throws Exception{
        mockMvc.perform(get("/productcategories"))
                .andDo(print())
                .andExpect(status().isOk());
    }
	
	@Ignore
    @Test
    public void getProductCategoryByIdTest() throws Exception{
        mockMvc.perform(get("/productcategories/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }
	
	@Ignore //how to set?
	@Test
	public void createProductCategoryControllerTest() throws Exception{
		ProductCategoryEntity productCategory  =  new ProductCategoryEntity();
		//productCategory.setProductId(productId);
		//productCategory.setCategoryId(1234l);
	
		
		
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(productCategory);
        mockMvc.perform(post("/productcategories") //.contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk());
		
	}
	
	@Ignore //how to set?
	@Test
	public void updateProductCategoryControllerTest() throws Exception{
		ProductCategoryEntity productCategory  =  new ProductCategoryEntity();
		//productCategory.setProductId(productId);
		//productCategory.setCategoryId(1234l);
	
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(productCategory);
        mockMvc.perform(post("/productcategories") //.contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk());
		
	}
	
	@Ignore
    @Test
    public void deleteProductCategoryByIdTest() throws Exception{
        mockMvc.perform(delete("/productcategories/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }
	
	

}
