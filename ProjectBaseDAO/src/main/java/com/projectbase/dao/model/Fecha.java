package com.projectbase.dao.model;

import java.io.Serializable;

/**
 * 
 * @author carlos.cardona
 */
public class Fecha implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9128978141471519648L;
	private String mes;
	private String anyo;

	public String getAnyo() {
		return anyo;
	}

	public void setAnyo(String anyo) {
		this.anyo = anyo;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public Fecha() {
	}

}
