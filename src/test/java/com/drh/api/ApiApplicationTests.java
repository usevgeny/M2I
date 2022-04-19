package com.drh.api;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest // est importante car on va tester plusieurs classes ensemble , elle va rendre l'applicaiton context disponible 
@AutoConfigureMockMvc
class ApiApplicationTests {
	@Autowired
	MockMvc mockMvc; 
	
	@Test
	void contextLoads() {
	}
	
// les test d'integration
	
	@Test
	public void TestGetController() throws Exception{
		
		mockMvc.perform(get("/employees")).andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$[0].nom", is("Charly")));
		
	}
	
	
	

}
