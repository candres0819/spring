package com.projectbase.dao.model;

import java.io.Serializable;

/**
 * 
 * 
 * @author carlos.cardona [20/12/2013]
 */
public class PermisosUsuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2779290965456454210L;
	private Integer idPermiso;
	private String nombrePermiso;

	public Integer getIdPermiso() {
		return idPermiso;
	}

	public void setIdPermiso(Integer idPermiso) {
		this.idPermiso = idPermiso;
	}

	public String getNombrePermiso() {
		return nombrePermiso;
	}

	public void setNombrePermiso(String nombrePermiso) {
		this.nombrePermiso = nombrePermiso;
	}

}
