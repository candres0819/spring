package com.projectbase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectbase.dao.ProjectBaseDAO;
import com.projectbase.dao.model.UsuarioSesion;

@Service
public class ProjectBaseServiceImpl implements ProjectBaseService {

	@Autowired
	private ProjectBaseDAO projectBaseDAO;

	@Override
	public UsuarioSesion validarUsuario(String login) {
		return projectBaseDAO.consultarUsuario(login);
	}
}
