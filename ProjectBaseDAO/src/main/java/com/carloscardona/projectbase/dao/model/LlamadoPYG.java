package com.carloscardona.projectbase.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @author carlos.cardona
 */
public class LlamadoPYG implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3506133862074707307L;

	private String nombre;

	private BigDecimal admonUen;
	private BigDecimal adei;
	private BigDecimal comercialUEN;
	private BigDecimal compras;
	private BigDecimal costosDirectos;
	private BigDecimal costosUEN;
	private BigDecimal diversos;
	private BigDecimal ebitda;
	private BigDecimal equiposComputo;
	private BigDecimal gaf;
	private BigDecimal gastosViajes;
	private BigDecimal ingresos;
	private BigDecimal imasdUEN;
	private BigDecimal npDirectas;
	private BigDecimal npUEN;
	private BigDecimal npGAF;
	private BigDecimal npTotal;
	private BigDecimal pmo;
	private BigDecimal salarios;
	private BigDecimal utilidadAI;
	private BigDecimal utilidadDA;
	private BigDecimal utilidadDirecta;
	private BigDecimal ingresosServicios;
	private BigDecimal ingresosLicencias;
	private BigDecimal salariosAdmonUEN;
	private BigDecimal salariosComercialUEN;
	private BigDecimal salariosImasdUEN;
	private BigDecimal otrosAdmonUEN;
	private BigDecimal otrosComercialUEN;
	private BigDecimal otrosImasDUEN;
	private BigDecimal salariosGAF;
	private BigDecimal otrosGAF;
	private BigDecimal salariosPMO;
	private BigDecimal otrosPMO;
	private BigDecimal personasAdmonUEN;
	private BigDecimal personasComercialUEN;
	private BigDecimal personasImasDUEN;
	private BigDecimal personasPMO;

	/*Datos calculados*/
	private BigDecimal ingresosServiciosXPD;
	private BigDecimal nominaXPD;
	private BigDecimal ebitdaXPD;
	private BigDecimal totalNomina;
	private BigDecimal porcentajeEbitda;
	/*Datos calculados*/

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getAdmonUen() {
		return admonUen;
	}

	public void setAdmonUen(BigDecimal admonUen) {
		this.admonUen = admonUen;
	}

	public BigDecimal getAdei() {
		return adei;
	}

	public void setAdei(BigDecimal adei) {
		this.adei = adei;
	}

	public BigDecimal getComercialUEN() {
		return comercialUEN;
	}

	public void setComercialUEN(BigDecimal comercialUEN) {
		this.comercialUEN = comercialUEN;
	}

	public BigDecimal getCompras() {
		return compras;
	}

	public void setCompras(BigDecimal compras) {
		this.compras = compras;
	}

	public BigDecimal getCostosDirectos() {
		return costosDirectos;
	}

	public void setCostosDirectos(BigDecimal costosDirectos) {
		this.costosDirectos = costosDirectos;
	}

	public BigDecimal getCostosUEN() {
		return costosUEN;
	}

	public void setCostosUEN(BigDecimal costosUEN) {
		this.costosUEN = costosUEN;
	}

	public BigDecimal getDiversos() {
		return diversos;
	}

	public void setDiversos(BigDecimal diversos) {
		this.diversos = diversos;
	}

	public BigDecimal getEbitda() {
		return ebitda;
	}

	public void setEbitda(BigDecimal ebitda) {
		this.ebitda = ebitda;
	}

	public BigDecimal getEquiposComputo() {
		return equiposComputo;
	}

	public void setEquiposComputo(BigDecimal equiposComputo) {
		this.equiposComputo = equiposComputo;
	}

	public BigDecimal getGaf() {
		return gaf;
	}

	public void setGaf(BigDecimal gaf) {
		this.gaf = gaf;
	}

	public BigDecimal getGastosViajes() {
		return gastosViajes;
	}

	public void setGastosViajes(BigDecimal gastosViajes) {
		this.gastosViajes = gastosViajes;
	}

	public BigDecimal getIngresos() {
		return ingresos;
	}

	public void setIngresos(BigDecimal ingresos) {
		this.ingresos = ingresos;
	}

	public BigDecimal getImasdUEN() {
		return imasdUEN;
	}

	public void setImasdUEN(BigDecimal imasdUEN) {
		this.imasdUEN = imasdUEN;
	}

	public BigDecimal getNpDirectas() {
		return npDirectas;
	}

	public void setNpDirectas(BigDecimal npDirectas) {
		this.npDirectas = npDirectas;
	}

	public BigDecimal getNpUEN() {
		return npUEN;
	}

	public void setNpUEN(BigDecimal npUEN) {
		this.npUEN = npUEN;
	}

	public BigDecimal getNpGAF() {
		return npGAF;
	}

	public void setNpGAF(BigDecimal npGAF) {
		this.npGAF = npGAF;
	}

	public BigDecimal getNpTotal() {
		return npTotal;
	}

	public void setNpTotal(BigDecimal npTotal) {
		this.npTotal = npTotal;
	}

	public BigDecimal getPmo() {
		return pmo;
	}

	public void setPmo(BigDecimal pmo) {
		this.pmo = pmo;
	}

	public BigDecimal getSalarios() {
		return salarios;
	}

	public void setSalarios(BigDecimal salarios) {
		this.salarios = salarios;
	}

	public BigDecimal getUtilidadAI() {
		return utilidadAI;
	}

	public void setUtilidadAI(BigDecimal utilidadAI) {
		this.utilidadAI = utilidadAI;
	}

	public BigDecimal getUtilidadDA() {
		return utilidadDA;
	}

	public void setUtilidadDA(BigDecimal utilidadDA) {
		this.utilidadDA = utilidadDA;
	}

	public BigDecimal getUtilidadDirecta() {
		return utilidadDirecta;
	}

	public void setUtilidadDirecta(BigDecimal utilidadDirecta) {
		this.utilidadDirecta = utilidadDirecta;
	}

	public BigDecimal getIngresosServicios() {
		return ingresosServicios;
	}

	public void setIngresosServicios(BigDecimal ingresosServicios) {
		this.ingresosServicios = ingresosServicios;
	}

	public BigDecimal getIngresosLicencias() {
		return ingresosLicencias;
	}

	public void setIngresosLicencias(BigDecimal ingresosLicencias) {
		this.ingresosLicencias = ingresosLicencias;
	}

	public BigDecimal getSalariosAdmonUEN() {
		return salariosAdmonUEN;
	}

	public void setSalariosAdmonUEN(BigDecimal salariosAdmonUEN) {
		this.salariosAdmonUEN = salariosAdmonUEN;
	}

	public BigDecimal getSalariosComercialUEN() {
		return salariosComercialUEN;
	}

	public void setSalariosComercialUEN(BigDecimal salariosComercialUEN) {
		this.salariosComercialUEN = salariosComercialUEN;
	}

	public BigDecimal getSalariosImasdUEN() {
		return salariosImasdUEN;
	}

	public void setSalariosImasdUEN(BigDecimal salariosImasdUEN) {
		this.salariosImasdUEN = salariosImasdUEN;
	}

	public BigDecimal getOtrosAdmonUEN() {
		return otrosAdmonUEN;
	}

	public void setOtrosAdmonUEN(BigDecimal otrosAdmonUEN) {
		this.otrosAdmonUEN = otrosAdmonUEN;
	}

	public BigDecimal getOtrosComercialUEN() {
		return otrosComercialUEN;
	}

	public void setOtrosComercialUEN(BigDecimal otrosComercialUEN) {
		this.otrosComercialUEN = otrosComercialUEN;
	}

	public BigDecimal getOtrosImasDUEN() {
		return otrosImasDUEN;
	}

	public void setOtrosImasDUEN(BigDecimal otrosImasDUEN) {
		this.otrosImasDUEN = otrosImasDUEN;
	}

	public BigDecimal getSalariosGAF() {
		return salariosGAF;
	}

	public void setSalariosGAF(BigDecimal salariosGAF) {
		this.salariosGAF = salariosGAF;
	}

	public BigDecimal getOtrosGAF() {
		return otrosGAF;
	}

	public void setOtrosGAF(BigDecimal otrosGAF) {
		this.otrosGAF = otrosGAF;
	}

	public BigDecimal getSalariosPMO() {
		return salariosPMO;
	}

	public void setSalariosPMO(BigDecimal salariosPMO) {
		this.salariosPMO = salariosPMO;
	}

	public BigDecimal getOtrosPMO() {
		return otrosPMO;
	}

	public void setOtrosPMO(BigDecimal otrosPMO) {
		this.otrosPMO = otrosPMO;
	}

	public BigDecimal getPersonasAdmonUEN() {
		return personasAdmonUEN;
	}

	public void setPersonasAdmonUEN(BigDecimal personasAdmonUEN) {
		this.personasAdmonUEN = personasAdmonUEN;
	}

	public BigDecimal getPersonasComercialUEN() {
		return personasComercialUEN;
	}

	public void setPersonasComercialUEN(BigDecimal personasComercialUEN) {
		this.personasComercialUEN = personasComercialUEN;
	}

	public BigDecimal getPersonasImasDUEN() {
		return personasImasDUEN;
	}

	public void setPersonasImasDUEN(BigDecimal personasImasDUEN) {
		this.personasImasDUEN = personasImasDUEN;
	}

	public BigDecimal getPersonasPMO() {
		return personasPMO;
	}

	public void setPersonasPMO(BigDecimal personasPMO) {
		this.personasPMO = personasPMO;
	}

	public BigDecimal getIngresosServiciosXPD() {
		return ingresosServiciosXPD;
	}

	public void setIngresosServiciosXPD(BigDecimal ingresosServiciosXPD) {
		this.ingresosServiciosXPD = ingresosServiciosXPD;
	}

	public BigDecimal getNominaXPD() {
		return nominaXPD;
	}

	public void setNominaXPD(BigDecimal nominaXPD) {
		this.nominaXPD = nominaXPD;
	}

	public BigDecimal getEbitdaXPD() {
		return ebitdaXPD;
	}

	public void setEbitdaXPD(BigDecimal ebitdaXPD) {
		this.ebitdaXPD = ebitdaXPD;
	}

	public BigDecimal getTotalNomina() {
		return totalNomina;
	}

	public void setTotalNomina(BigDecimal totalNomina) {
		this.totalNomina = totalNomina;
	}

	public BigDecimal getPorcentajeEbitda() {
		return porcentajeEbitda;
	}

	public void setPorcentajeEbitda(BigDecimal porcentajeEbitda) {
		this.porcentajeEbitda = porcentajeEbitda;
	}

}
