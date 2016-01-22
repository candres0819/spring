package com.projectbase.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.projectbase.dao.model.AdmonCentrosCostos;

/**
 * Clase utilizada para realizar el mapeo del resultado de la consulta a base de
 * datos.
 * 
 * @author carlos.cardona [19/12/2013]
 */
@SuppressWarnings("rawtypes")
public class AdmonCentrosCostosRMI implements RowMapper {

	public Object mapRow(final ResultSet result, final int rowNumber) throws SQLException {

		final AdmonCentrosCostos admonCentrosCostos = new AdmonCentrosCostos();

		Integer aplica = null;
		Integer gerenc = null;
		String estado = null;
		Integer id = null;
		Integer idDirector = null;
		String idDirectorPersona = null;
		Integer idUen = null;
		String idUenString = null;
		String nombre = null;
		String nombrePersona = null;
		String nombreUen = null;
		
		try {
			aplica = result.getInt("aplicaPYG");
		} catch (Exception e) {
		}
		try {
			gerenc = result.getInt("esGerencia");
		} catch (Exception e) {
		}
		try {
			estado = result.getInt("estado") == 1 ? "Habilitado" : "Inhabilitado";
		} catch (Exception e) {
		}
		try {
			id = result.getInt("id");
		} catch (Exception e) {
		}
		try {
			idDirector = result.getInt("idDirector");
		} catch (Exception e) {
		}
		
		try {
			idDirectorPersona = result.getString("idDirectorPersona").trim();
		} catch (Exception e) {
		}
		try {
			idUen = result.getInt("idUen");
		} catch (Exception e) {
		}
		try {
			idUenString = result.getString("idUenString").trim();
		} catch (Exception e) {
		}
		try {
			nombre = result.getString("nombre").trim();
		} catch (Exception e) {
		}
		try {
			nombrePersona = result.getString("nombrePersona").trim();
		} catch (Exception e) {
		}
		try {
			nombreUen = result.getString("nombreUen").trim();
		} catch (Exception e) {
		}
		
		admonCentrosCostos.setAplicaPyg(aplica);
		admonCentrosCostos.setEsGerencia(gerenc);
		admonCentrosCostos.setEstado(estado);
		admonCentrosCostos.setId(id);
		admonCentrosCostos.setIdDirector(idDirector);
		admonCentrosCostos.setIdDirectorPersonas(idDirectorPersona);
		admonCentrosCostos.setIdUen(idUen);
		admonCentrosCostos.setIduenString(idUenString);
		admonCentrosCostos.setNombre(nombre);
		admonCentrosCostos.setNombrePersona(nombrePersona);
		admonCentrosCostos.setNombreUen(nombreUen);

		return admonCentrosCostos;
	}

}
