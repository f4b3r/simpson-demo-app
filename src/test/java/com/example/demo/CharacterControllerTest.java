package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class CharacterControllerTest {

	@Autowired 
	private MockMvc mockMvc;
	
	 @Test
	  public void testErrorPageForwardOnDelete() throws Exception {
	   
	   
	   this.mockMvc.perform(get("/character/delete/null")).andDo(print()).andExpect(status().is5xxServerError())
		.andExpect(view().name("/error"));
	}
}
