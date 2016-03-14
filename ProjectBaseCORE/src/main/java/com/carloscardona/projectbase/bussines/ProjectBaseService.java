package com.carloscardona.projectbase.bussines;

import com.carloscardona.projectbase.dao.model.UsuarioSesion;

/**
 * 
 * @author candr
 *
 */
public interface ProjectBaseService {

	/**
	 * 
	 * @param login
	 * @return
	 */
	UsuarioSesion validarUsuario(String login);

}
