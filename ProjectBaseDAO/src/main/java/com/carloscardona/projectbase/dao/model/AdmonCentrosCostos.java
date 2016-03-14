package com.carloscardona.projectbase.dao.model;

import java.io.Serializable;

/**
 * 
 * @author carlos.cardona
 */
public class AdmonCentrosCostos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5568778757599722095L;
	private Integer id;
	private String nombre;
	private Integer idDirector;
	private String nombrePersona;
	private Integer idUen;
	private String nombreUen;
	private Integer esGerencia;
	private Integer aplicaPyg;
	private String estado;
	private String idDirectorPersonas;
	private String iduenString;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getIdDirector() {
		return idDirector;
	}

	public void setIdDirector(Integer idDirector) {
		this.idDirector = idDirector;
	}

	public String getNombrePersona() {
		return nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	public Integer getIdUen() {
		return idUen;
	}

	public void setIdUen(Integer idUen) {
		this.idUen = idUen;
	}

	public String getNombreUen() {
		return nombreUen;
	}

	public void setNombreUen(String nombreUen) {
		this.nombreUen = nombreUen;
	}

	public Integer getEsGerencia() {
		return esGerencia;
	}

	public void setEsGerencia(Integer esGerencia) {
		this.esGerencia = esGerencia;
	}

	public Integer getAplicaPyg() {
		return aplicaPyg;
	}

	public void setAplicaPyg(Integer aplicaPyg) {
		this.aplicaPyg = aplicaPyg;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getIdDirectorPersonas() {
		return idDirectorPersonas;
	}

	public void setIdDirectorPersonas(String idDirectorPersonas) {
		this.idDirectorPersonas = idDirectorPersonas;
	}

	public String getIduenString() {
		return iduenString;
	}

	public void setIduenString(String iduenString) {
		this.iduenString = iduenString;
	}

}