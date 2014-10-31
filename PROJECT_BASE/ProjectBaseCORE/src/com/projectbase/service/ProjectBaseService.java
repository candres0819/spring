package com.projectbase.service;

import com.projectbase.dao.model.UsuarioSesion;

public interface ProjectBaseService {

	/**
	 * 
	 * @param login
	 * @return
	 */
	UsuarioSesion validarUsuario(String login);

}
