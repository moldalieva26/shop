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
import com.furnitureshop.app.v1.entity.OrderDetailEntity;
import com.furnitureshop.app.v1.entity.ProductEntity;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes={SpringBootApplication.class})
@WebAppConfiguration
@AutoConfigureMockMvc
@ComponentScan(basePackages = {"com.furnitureshop"}) 
@WithUserDetails(value="testuser3", userDetailsServiceBeanName="userDetailsServiceImpl")
public class ProductControllerTest {
	@Autowired 
	MockMvc mockMvc;
	
	@Ignore
    @Test
    public void getAllProductsTest() throws Exception{
        mockMvc.perform(get("/products"))
                .andDo(print())
                .andExpect(status().isOk());
    }
	
	@Ignore
    @Test
    public void getProducByIdsTest() throws Exception{
        mockMvc.perform(get("/products/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    
    

	@Ignore
	@Test
	public void createProductTest() throws Exception{
		ProductEntity product  =  new ProductEntity();
		product.setCategoryId(1111l);
		product.setProductName("chair");
		product.setQuantityAvailable(123);

		
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(product);
        mockMvc.perform(post("/products").contentType(APPLICATION_JSON_UTF8) // 415 status code
                .content(requestJson))
                .andExpect(status().isOk());
		
	}
	
	
	@Ignore
	@Test
	public void updateProductTest() throws Exception{
		ProductEntity product  =  new ProductEntity();
		product.setCategoryId(1111l);
		product.setProductName("chairUpdated");
		product.setQuantityAvailable(123);

		
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(product);
        mockMvc.perform(put("/products/41").contentType(APPLICATION_JSON_UTF8) // 415 status code
                .content(requestJson));
	
	}
	
	@Ignore
	@Test
	public void deleteProductByIdTest() throws Exception{
		this.mockMvc.perform(delete("/products/3")).andDo(print())
		.andExpect(status().isOk());
		
	}



	
	
}
