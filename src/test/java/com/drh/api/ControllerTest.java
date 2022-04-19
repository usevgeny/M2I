package com.drh.api;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import org.junit.jupiter.api.Test;
import org.mockito.plugins.MockMaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.drh.api.Model.service.EmployeeService;
import com.drh.api.controller.EmployeeController;

//mockMvc permettent de tester les controlleurs
//definir un objet mockMVC pour tester les conrolleurs
@WebMvcTest(controllers = EmployeeController.class)
public class ControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	// pour simuler un objet
	@MockBean
	private EmployeeService employeeService;
	
	@Test
	public void whenCallingGetMapping_WeReceilve_GoodStatus() throws Exception {
		
		mockMvc.perform(get("/employees")).andExpect(status().isOk());}
		
	@Test
	public void whenCallingPostMapping_WeReceilve_GoodStatus() throws Exception {
			
		mockMvc.perform(post("/employees")).andExpect(status().isOk());
			
		
	};
	
	
	
	
}
