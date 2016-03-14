package com.carloscardona.projectbase.dao.model;

import java.io.Serializable;

/**
 * 
 * @author carlos.cardona
 */
public class UltimoPYG implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1523382476345618493L;
	private Integer id;
	private Integer mes;
	private Integer anyo;
	private String estado;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Integer getAnyo() {
		return anyo;
	}

	public void setAnyo(Integer anyo) {
		this.anyo = anyo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}