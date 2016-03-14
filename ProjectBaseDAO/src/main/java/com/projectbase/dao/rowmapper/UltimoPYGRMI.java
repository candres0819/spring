package com.projectbase.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.projectbase.dao.model.UltimoPYG;

/**
 * 
 * 
 * @author carlos.cardona [20/01/2014]
 */
@SuppressWarnings("rawtypes")
public class UltimoPYGRMI implements RowMapper {

	public Object mapRow(final ResultSet result, final int rowNumber) throws SQLException {

		final UltimoPYG ultimoPYG = new UltimoPYG();

		ultimoPYG.setAnyo(result.getInt("anyo"));
		ultimoPYG.setEstado(result.getString("estado").trim());
		ultimoPYG.setId(result.getInt("id"));
		ultimoPYG.setMes(result.getInt("mes"));

		return ultimoPYG;
	}
}
