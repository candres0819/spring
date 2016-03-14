package com.projectbase.dao.model;

import java.io.Serializable;

/**
 * 
 * 
 * @author carlos.cardona [19/12/2013]
 */
public class Equipo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idEquipo;
	private String nombreEquipo;
	private Integer idPersonaDirector;
	private Integer idUen;
	private Integer aplicaPyg;
	private Integer estado;

	public Integer getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(Integer idEquipo) {
		this.idEquipo = idEquipo;
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public Integer getIdPersonaDirector() {
		return idPersonaDirector;
	}

	public void setIdPersonaDirector(Integer idPersonaDirector) {
		this.idPersonaDirector = idPersonaDirector;
	}

	public Integer getIdUen() {
		return idUen;
	}

	public void setIdUen(Integer idUen) {
		this.idUen = idUen;
	}

	public Integer getAplicaPyg() {
		return aplicaPyg;
	}

	public void setAplicaPyg(Integer aplicaPyg) {
		this.aplicaPyg = aplicaPyg;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

}
