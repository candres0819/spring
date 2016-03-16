package com.carloscardona.projectbase.bussines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carloscardona.projectbase.dao.ProjectBaseDAO;
import com.carloscardona.projectbase.dao.model.UsuarioSesion;

@Service
public class ProjectBaseServiceImpl implements ProjectBaseService {

	@Autowired
	private ProjectBaseDAO projectBaseDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.carloscardona.projectbase.bussines.ProjectBaseService#validarUsuario(java.lang.String)
	 */
	@Override
	public UsuarioSesion validarUsuario(String login) {
		return projectBaseDAO.consultarUsuario(login);
	}
}
