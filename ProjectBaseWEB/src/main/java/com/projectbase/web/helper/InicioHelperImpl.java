package com.projectbase.web.helper;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.carloscardona.spring.projectbase.bussines.ProjectBaseService;
import com.carloscardona.spring.projectbase.support.Constantes;
import com.projectbase.dao.model.UsuarioSesion;

@Component
public class InicioHelperImpl implements InicioHelper {

	@Autowired
	private ProjectBaseService projectBaseService;

	@Override
	public void validarUsuario(HttpServletRequest request, Model model) throws Exception {
		String login = request.getParameter("login");
		UsuarioSesion usuario = projectBaseService.validarUsuario(login);

		if (null != usuario) {
			request.getSession().setAttribute(Constantes.USUARIO_SESSION, usuario);
			model.addAttribute("usuario", usuario);
		} else {
			throw new Exception("usuario no encontrado");
		}
	}

}
