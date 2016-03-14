package com.carloscardona.projectbase.dao.exec.sql;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

public class SqlQueryServicio extends StoredProcedure {

	protected HashMap<String, Object> listaValorParametros;
	private String[] namesRowMapper = {};

	/**
	 * @return the countRowMapperAux
	 */
	public String[] getNamesRowMapper() {
		return namesRowMapper;
	}

	/**
	 * Para ejecutar SPs que retornen ResultSet
	 * 
	 * @param jdbcTemplate
	 * @param name
	 * @param listaParametros
	 * @param listaValorParametros
	 * @param rowMapper
	 */
	public SqlQueryServicio(JdbcTemplate jdbcTemplate, String name, ArrayList<SqlParameter> listaParametros,
			HashMap<String, Object> listaValorParametros, RowMapper rowMapper) {

		super(jdbcTemplate, name);

		if (null == listaParametros ^ null == listaValorParametros) {
			throw new RuntimeException("Cantidad de Parametros y de Valores no son iguales");
		}
		int cantParamIn = 0;
		for (SqlParameter parametro : listaParametros) {

			if (SqlParameter.class.getName().equals(parametro.getClass().getName())
					|| SqlInOutParameter.class.getName().equals(parametro.getClass().getName())) {
				cantParamIn++;
			}
		}
		if (null != listaParametros && null != listaValorParametros && cantParamIn != listaValorParametros.size()) {
			throw new RuntimeException("Cantidad de Parametros y de Valores no son iguales");
		}

		this.listaValorParametros = listaValorParametros;

		declareParameter(new SqlReturnResultSet("resultSet", rowMapper));

		// Parametros de ejecucion
		for (SqlParameter sqlParameter : listaParametros) {
			declareParameter(sqlParameter);
		}
	}

	/**
	 * Para ejecutar SPs que retornen ResultSet
	 * 
	 * @param jdbcTemplate
	 * @param name
	 * @param listaParametros
	 * @param listaValorParametros
	 * @param rowMapper
	 */
	public SqlQueryServicio(JdbcTemplate jdbcTemplate, String name, ArrayList<SqlParameter> listaParametros,
			HashMap<String, Object> listaValorParametros, RowMapper rowMapper1, RowMapper rowMapper2) {

		super(jdbcTemplate, name);

		if (null == listaParametros ^ null == listaValorParametros) {
			throw new RuntimeException("Cantidad de Parametros y de Valores no son iguales");
		}
		int cantParamIn = 0;
		for (SqlParameter parametro : listaParametros) {

			if (SqlParameter.class.getName().equals(parametro.getClass().getName())
					|| SqlInOutParameter.class.getName().equals(parametro.getClass().getName())) {
				cantParamIn++;
			}
		}
		if (null != listaParametros && null != listaValorParametros && cantParamIn != listaValorParametros.size()) {
			throw new RuntimeException("Cantidad de Parametros y de Valores no son iguales");
		}

		this.listaValorParametros = listaValorParametros;

		declareParameter(new SqlReturnResultSet("resultSet1", rowMapper1));

		declareParameter(new SqlReturnResultSet("resultSet2", rowMapper2));

		// Parametros de ejecucion
		for (SqlParameter sqlParameter : listaParametros) {
			declareParameter(sqlParameter);
		}
	}

	public SqlQueryServicio(JdbcTemplate jdbcTemplate, String name, ArrayList<SqlParameter> listaParametros,
			HashMap<String, Object> listaValorParametros) {

		super(jdbcTemplate, name);

		if (null == listaParametros ^ null == listaValorParametros) {
			throw new RuntimeException("Cantidad de Parametros y de Valores no son iguales");
		}
		int cantParamIn = 0;
		for (SqlParameter parametro : listaParametros) {

			if (SqlParameter.class.getName().equals(parametro.getClass().getName())
					|| SqlInOutParameter.class.getName().equals(parametro.getClass().getName())) {
				cantParamIn++;
			}
		}
		if (null != listaParametros && null != listaValorParametros && cantParamIn != listaValorParametros.size()) {
			throw new RuntimeException("Cantidad de Parametros y de Valores no son iguales");
		}

		this.listaValorParametros = listaValorParametros;

		// Parametros de ejecucion
		for (SqlParameter sqlParameter : listaParametros) {
			declareParameter(sqlParameter);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.jdbc.object.StoredProcedure#execute(java.util.Map)
	 */
	/*@Override
	@SuppressWarnings("unchecked")
	public final Map execute(Map inParams) throws RuntimeException {

		Map<String, Object> resultado = new HashMap<String, Object>();
		try {
			resultado = super.execute(inParams);
		} catch (RuntimeException e) {
			logger.error("Exception StoreProcedurePreafiliacionPO.execute ");
			logger.error("Error ejecutando '" + this.getCallString() + "'");
			logger.error("Parametros:");
			Object[] parametersValues = inParams.values().toArray();
			for (int i = 0; i < parametersValues.length; i++) {
				Object object = parametersValues[i];
				logger.error("[" + i + "]: " + object);
			}
			logger.error(e);
			throw new RuntimeException("Error realizando la ejecucion del Proceso, por favor intente mas tarde", e);
		}

		return resultado;
	}*/

	/**
	 * 
	 * @return
	 * @throws RuntimeException
	 */
	@SuppressWarnings("unchecked")
	public final Map<String, Object> executeQuery() throws RuntimeException {
		Map<String, Object> resultado = new HashMap<String, Object>();

		if (null != listaValorParametros) {

			resultado = this.execute(listaValorParametros);

		} else {
			throw new RuntimeException("Parametros para ejecutar el Query '" + this.getSql() + "' NULL");
		}
		return resultado;
	}

}
