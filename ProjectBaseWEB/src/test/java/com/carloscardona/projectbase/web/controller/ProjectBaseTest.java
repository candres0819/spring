package com.carloscardona.projectbase.web.controller;

import java.util.Locale;

import javax.servlet.ServletContext;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.ui.Model;
import org.springframework.web.context.WebApplicationContext;

public class ProjectBaseTest {

	@Autowired
	private WebApplicationContext wac;

	private InicioController inicioController = new InicioController();

	private MockHttpServletRequest request;

	private ServletContext servletContext;

	Model model;

	@Before
	public void before() throws Exception {
		this.request = new MockHttpServletRequest();
		this.servletContext = new MockServletContext();
	}

	@Test
	public void testInicio() {
		try {
			String mav = inicioController.home(new Locale("es"), model);
			Assert.assertEquals("inicio", mav);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testMenu() {
		String mav = "";
		try {
			mav = inicioController.onSubmit(request, model);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertEquals("menu", mav);
	}
}
