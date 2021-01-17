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
import com.furnitureshop.app.v1.entity.ProductTagEntity;
import com.furnitureshop.app.v1.entity.TagEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes={SpringBootApplication.class})
@WebAppConfiguration
@AutoConfigureMockMvc
@ComponentScan(basePackages = {"com.furnitureshop"}) 
@WithUserDetails(value="testuser3", userDetailsServiceBeanName="userDetailsServiceImpl")
public class ProductTagControllerTest {
	@Autowired
    private MockMvc mockMvc;
	
	@Ignore
    @Test
    public void getAllProductTagsTest() throws Exception{
        mockMvc.perform(get("/producttags"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    
	@Ignore
	@Test
	public void getProductTagByIdTest() throws Exception{
		this.mockMvc.perform(get("/producttags/30")).andDo(print())
		.andExpect(status().isOk());
		
	}
	
	@Ignore
	@Test
	public void createProductTagTest() throws Exception{
		ProductTagEntity productTag  =  new ProductTagEntity();
	//	productTag.setProductId(productId); ??
	
		
		
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(productTag);
        mockMvc.perform(post("/producttags").contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk());
		
	}
	
	
	@Ignore
	@Test
	public void updateProductTagTest() throws Exception{
		ProductTagEntity productTag  =  new ProductTagEntity();
		//	productTag.setProductId(productId); ??
		// i have only entities ProductTag
		
			
			
		
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(productTag);
        mockMvc.perform(put("/producttags/42").contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk());
		
	}
	
	@Ignore
	@Test
	public void deleteProductTagByIdTest() throws Exception{
		this.mockMvc.perform(delete("/producttags/30")).andDo(print())
		.andExpect(status().isOk());
		
	}

}
