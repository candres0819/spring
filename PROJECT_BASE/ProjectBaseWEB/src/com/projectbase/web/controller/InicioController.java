package com.projectbase.web.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projectbase.web.helper.InicioHelper;

/**
 * Handles requests for the application home page.
 */
@Controller
public class InicioController {

	private static final Logger logger = LoggerFactory.getLogger(InicioController.class);

	@Autowired
	private InicioHelper inicioHelper;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		return "inicio";
	}

	@RequestMapping(value = "/menu", method = RequestMethod.POST)
	public String onSubmit(HttpServletRequest request, Model model) throws Exception {
		logger.info("Menu");
		try {
			inicioHelper.validarUsuario(request, model);
			return "menu";
		} catch (Exception e) {
			throw e;
		}
	}
}
