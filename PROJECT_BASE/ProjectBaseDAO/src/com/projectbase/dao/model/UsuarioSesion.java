package com.projectbase.dao.model;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * 
 * @author carlos.cardona [19/12/2013]
 */
public class UsuarioSesion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idUsuario;
	private List<PermisosUsuario> permisos;
	private Integer idPermiso;
	private String login;
	private Integer idRol;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdPermiso() {
		return idPermiso;
	}

	public List<PermisosUsuario> getPermisos() {
		return permisos;
	}

	public void setPermisos(List<PermisosUsuario> permisos) {
		this.permisos = permisos;
	}

	public void setIdPermiso(Integer idPermiso) {
		this.idPermiso = idPermiso;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

}
