package com.carloscardona.spring.projectbase.bussines;

import com.projectbase.dao.model.UsuarioSesion;

public interface ProjectBaseService {

	/**
	 * 
	 * @param login
	 * @return
	 */
	UsuarioSesion validarUsuario(String login);

}
