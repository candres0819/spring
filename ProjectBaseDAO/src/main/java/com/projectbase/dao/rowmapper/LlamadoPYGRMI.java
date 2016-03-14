package com.projectbase.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.projectbase.dao.model.FinPYG;

/**
 * Clase utilizada para realizar el mapeo del resultado de la consulta a base de
 * datos.
 * 
 * @author carlos.cardona [19/12/2013]
 */
@SuppressWarnings("rawtypes")
public class LlamadoPYGRMI implements RowMapper {

	public Object mapRow(final ResultSet result, final int rowNumber) throws SQLException {

		final FinPYG finPYG = new FinPYG();

		finPYG.setIdTipoMovimiento(result.getInt("idTipoMovimiento"));
		finPYG.setValor(result.getBigDecimal("valor"));

		return finPYG;
	}

}
