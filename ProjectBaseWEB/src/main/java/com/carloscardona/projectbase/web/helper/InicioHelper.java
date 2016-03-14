package com.carloscardona.projectbase.web.helper;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface InicioHelper {

	/**
	 * 
	 * @param request
	 * @param model
	 * @throws Exception
	 */
	void validarUsuario(HttpServletRequest request, Model model) throws Exception;

}
