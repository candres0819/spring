package com.projectbase.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.projectbase.dao.model.Equipo;

/**
 * Clase utilizada para realizar el mapeo del resultado de la consulta a base de
 * datos.
 * 
 * @author carlos.cardona [19/12/2013]
 */
@SuppressWarnings("rawtypes")
public class EquipoRMI implements RowMapper {

	public Object mapRow(final ResultSet result, final int rowNumber) throws SQLException {

		final Equipo equipo = new Equipo();

		equipo.setAplicaPyg(result.getInt("aplicaPYG"));
		equipo.setEstado(result.getInt("estado"));
		equipo.setIdEquipo(result.getInt("idEquipo"));
		equipo.setIdPersonaDirector(result.getInt("idPersonaDirector"));
		equipo.setIdUen(result.getInt("idUen"));
		equipo.setNombreEquipo(result.getString("nombreEquipo").trim());

		return equipo;
	}

}
