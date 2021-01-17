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
import com.furnitureshop.app.v1.entity.ProductTagEntity;
import com.furnitureshop.app.v1.entity.TagEntity;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes={SpringBootApplication.class})
@WebAppConfiguration
@AutoConfigureMockMvc
@ComponentScan(basePackages = {"com.furnitureshop"}) 
@WithUserDetails(value="testuser3", userDetailsServiceBeanName="userDetailsServiceImpl")
public class TagControllerTest {
	@Autowired
    private MockMvc mockMvc;
	
	@Ignore
    @Test
    public void getAllTagsTest() throws Exception{
        mockMvc.perform(get("/tags"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    
	@Ignore
	@Test
	public void getTagByIdTest() throws Exception{
		this.mockMvc.perform(get("/tags/13")).andDo(print())
		.andExpect(status().isOk());
		
	}
	
	@Ignore
	@Test
	public void createTagControllerTest() throws Exception{
		TagEntity tag  =  new TagEntity();
		tag.setTagName("Sofa");
		//check set...() methods in Entity Class
		// instance is created but the values are not set
		
		
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(tag);
        mockMvc.perform(post("/tags").contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk());
		
	}
	
	
	@Ignore
	@Test
	public void updateTagControllerTest() throws Exception{
		TagEntity tag  =  new TagEntity();
		tag.setTagName("sofa"); // did not work
		//tag.setProductTagId(28l); how to pass another entity?
		//ProductTagEntity productTag = new ProductTagEntity();
		//tag.setProductTagId(productTag);
		//check set...() methods in Entity Class
		
		
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(tag);
        mockMvc.perform(put("/tags/42").contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk());
		
	}
	
	@Ignore
	@Test
	public void deleteTagByIdTest() throws Exception{
		this.mockMvc.perform(delete("/tags/1112")).andDo(print())
		.andExpect(status().isOk());
		
	}

}
