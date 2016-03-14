package com.carloscardona.projectbase.dao.exec.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

/**
 * 
 * 
 * @author carlos.cardona [19/12/2013]
 */
@SuppressWarnings("rawtypes")
public class MappingSqlQueryServicio extends MappingSqlQuery {

	private RowMapper rowMapper;

	protected LinkedHashMap<String, Object> listaValorParametros;

	/**
	 * Solo para ejecutar SELECT
	 * 
	 * @param ds
	 * @param sql
	 */
	public MappingSqlQueryServicio(JdbcTemplate jdbcTemplate, String sql, LinkedList<SqlParameter> listaParametros,
			LinkedHashMap<String, Object> listaValorParametros, RowMapper rowMapper) {
		super(jdbcTemplate.getDataSource(), sql);
		this.listaValorParametros = listaValorParametros;
		this.rowMapper = rowMapper;

		// Parametros de entrada
		for (SqlParameter sqlParameter : listaParametros) {
			declareParameter(sqlParameter);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.jdbc.object.MappingSqlQuery#mapRow(java.sql.ResultSet
	 * , int)
	 */
	@Override
	protected Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		return rowMapper.mapRow(rs, rowNum);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.jdbc.object.StoredProcedure#execute(java.util.Map)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public final List execute(Map inParams) throws RuntimeException {

		List<Object> resultado = new ArrayList<Object>();
		try {
			resultado = super.execute(inParams.values().toArray(), inParams);

		} catch (RuntimeException e) {
			throw new RuntimeException("Error realizando la consulta, por favor intente mas tarde", e);
		}

		return resultado;
	}

	@SuppressWarnings("unchecked")
	public final List<Object> executeQuery() throws RuntimeException {
		List<Object> resultado = new ArrayList<Object>();

		if (null != listaValorParametros) {

			resultado = this.execute(listaValorParametros);

		} else {
			throw new RuntimeException("Error ejecutando la consulta");
		}
		return resultado;
	}

}
