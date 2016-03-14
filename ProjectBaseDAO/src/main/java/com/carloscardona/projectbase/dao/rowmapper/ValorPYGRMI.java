package com.carloscardona.projectbase.dao.rowmapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * Clase utilizada para realizar el mapeo del resultado de la consulta a base de
 * datos.
 * 
 * @author carlos.cardona [19/12/2013]
 */
@SuppressWarnings("rawtypes")
public class ValorPYGRMI implements RowMapper {

	public Object mapRow(final ResultSet result, final int rowNumber) throws SQLException {

		BigDecimal valor = BigDecimal.ZERO;

		valor = result.getBigDecimal("valor");

		return valor;
	}

}
