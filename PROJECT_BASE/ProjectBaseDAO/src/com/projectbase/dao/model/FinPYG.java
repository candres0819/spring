package com.projectbase.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @author carlos.cardona
 */
public class FinPYG implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1659206404769762470L;

	private Integer idTipoMovimiento;
	private BigDecimal valor;

	public Integer getIdTipoMovimiento() {
		return idTipoMovimiento;
	}

	public void setIdTipoMovimiento(Integer idTipoMovimiento) {
		this.idTipoMovimiento = idTipoMovimiento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public FinPYG() {
		super();
	}

	public FinPYG(Integer idTipoMovimiento, BigDecimal valor) {
		super();
		this.idTipoMovimiento = idTipoMovimiento;
		this.valor = valor;
	}

}
