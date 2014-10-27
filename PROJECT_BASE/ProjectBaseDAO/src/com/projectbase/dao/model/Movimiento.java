package com.projectbase.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Movimiento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9094764432592447597L;
	private int idParametro;
	private BigDecimal suma;

	public int getIdParametro() {
		return idParametro;
	}

	public void setIdParametro(int idParametro) {
		this.idParametro = idParametro;
	}

	public BigDecimal getSuma() {
		return suma;
	}

	public void setSuma(BigDecimal suma) {
		this.suma = suma;
	}
}
