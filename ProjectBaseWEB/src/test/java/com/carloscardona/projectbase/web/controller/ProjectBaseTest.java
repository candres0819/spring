package com.carloscardona.projectbase.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/appContext-projectBaseWEB-test.xml" })
@WebAppConfiguration
public class ProjectBaseTest {

	private MockMvc mockMvc;

	@InjectMocks
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testInicio() throws Exception {
		mockMvc.perform(get("/")).andExpect(status().isOk());
	}

	@Test
	public void testMenu() {
		try {
			mockMvc.perform(post("/addNewApplicant").param("key1", "value1").param("key2", "value2")).andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
