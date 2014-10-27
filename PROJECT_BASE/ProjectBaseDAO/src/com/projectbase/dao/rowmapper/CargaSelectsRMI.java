package com.projectbase.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.projectbase.dao.model.CargaSelects;

/**
 * Clase utilizada para realizar el mapeo del resultado de la consulta a base de
 * datos.
 * 
 * @author carlos.cardona [19/12/2013]
 */
@SuppressWarnings("rawtypes")
public class CargaSelectsRMI implements RowMapper {

	public Object mapRow(final ResultSet result, final int rowNumber) throws SQLException {

		final CargaSelects cargaSelects = new CargaSelects();

		cargaSelects.setId(result.getInt("id"));
		cargaSelects.setNombre(result.getString("nombre").trim());

		return cargaSelects;
	}

}
