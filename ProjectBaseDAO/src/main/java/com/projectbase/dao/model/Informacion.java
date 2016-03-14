package com.projectbase.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Informacion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1029605689712532532L;

	private Integer idMovimiento;
	private BigDecimal valor;
	private Integer idUen;
	private Integer uenAplicaPYG;
	private Integer idLinea;
	private Integer lineaAplicaPYG;
	private Integer idCliente;
	private Integer clienteAplicaPYG;
	private Integer idRegion;
	private Integer regionAplicaPYG;
	private Integer idContrato;
	private Integer contratoAplicaPYG;

	public Integer getIdMovimiento() {
		return idMovimiento;
	}

	public void setIdMovimiento(Integer idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Integer getIdUen() {
		return idUen;
	}

	public void setIdUen(Integer idUen) {
		this.idUen = idUen;
	}

	public Integer getUenAplicaPYG() {
		return uenAplicaPYG;
	}

	public void setUenAplicaPYG(Integer uenAplicaPYG) {
		this.uenAplicaPYG = uenAplicaPYG;
	}

	public Integer getIdLinea() {
		return idLinea;
	}

	public void setIdLinea(Integer idLinea) {
		this.idLinea = idLinea;
	}

	public Integer getLineaAplicaPYG() {
		return lineaAplicaPYG;
	}

	public void setLineaAplicaPYG(Integer lineaAplicaPYG) {
		this.lineaAplicaPYG = lineaAplicaPYG;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Integer getClienteAplicaPYG() {
		return clienteAplicaPYG;
	}

	public void setClienteAplicaPYG(Integer clienteAplicaPYG) {
		this.clienteAplicaPYG = clienteAplicaPYG;
	}

	public Integer getIdRegion() {
		return idRegion;
	}

	public void setIdRegion(Integer idRegion) {
		this.idRegion = idRegion;
	}

	public Integer getRegionAplicaPYG() {
		return regionAplicaPYG;
	}

	public void setRegionAplicaPYG(Integer regionAplicaPYG) {
		this.regionAplicaPYG = regionAplicaPYG;
	}

	public Integer getIdContrato() {
		return idContrato;
	}

	public void setIdContrato(Integer idContrato) {
		this.idContrato = idContrato;
	}

	public Integer getContratoAplicaPYG() {
		return contratoAplicaPYG;
	}

	public void setContratoAplicaPYG(Integer contratoAplicaPYG) {
		this.contratoAplicaPYG = contratoAplicaPYG;
	}

	public String getKey() {
		return (this.getUenAplicaPYG() == 1 ? this.getIdUen() : 0) + " " + (this.getLineaAplicaPYG() == 1 ? this.getIdLinea() : 0) + " "
				+ this.getIdCliente() + " " + this.getIdContrato();
	}
}
