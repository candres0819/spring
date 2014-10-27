package com.projectbase.dao.exec.sql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.BatchSqlUpdate;
import org.springframework.jdbc.object.SqlUpdate;

public class SqlInsertServicio extends SqlUpdate {

	/**
	 * Solo para ejecutar INSERT, UPDATE, DELETE
	 * 
	 * @param ds
	 * @param sql
	 */
	public SqlInsertServicio(final JdbcTemplate jdbcTemplate, final String sql, final List<SqlParameter> listaParametros) {
		super(jdbcTemplate.getDataSource(), sql);

		// Parametros de entrada
		for (SqlParameter sqlParameter : listaParametros) {
			declareParameter(sqlParameter);
		}
	}

	protected final int[] getTiposParametrosSQL() {

		final List<SqlParameter> parametrosSQL = getDeclaredParameters();
		int[] tipoParametros = new int[parametrosSQL.size()];
		int ubicacion = 0;
		for (SqlParameter sqlParameter : parametrosSQL) {
			tipoParametros[ubicacion] = sqlParameter.getSqlType();
			ubicacion++;
		}
		return tipoParametros;
	}

	/**
	 * 
	 * @param listaValorPar
	 * @return
	 * @throws RuntimeException
	 */
	public final int executeQuery(final Map<String, Object> listaValorPar) throws RuntimeException {
		int resultado = 0;

		if (null == listaValorPar) {

			throw new RuntimeException("Parametros para ejecutar el Query '" + this.getSql() + "' NULL");

		} else {
			final Object[] params = listaValorPar.values().toArray();
			resultado = super.update(params);

		}

		return resultado;
	}

	/**
	 * 
	 * @param listaValorPar
	 * @return
	 * @throws RuntimeException
	 */
	public final Map<String, Object> executeQueries(final List<Object[]> listaValorPar) throws RuntimeException {
		final Map<String, Object> resultado = new HashMap<String, Object>();

		if (null == listaValorPar) {
			throw new RuntimeException("Parametros para ejecutar el Query '" + this.getSql() + "' NULL");

		} else {
			final BatchSqlUpdate batchSqlUpdate = new BatchSqlUpdate(this.getJdbcTemplate().getDataSource(), this.getSql(),
					this.getTiposParametrosSQL());
			try {
				for (Object parameterEntry : listaValorPar) {
					final Object[] parametersValues = (Object[]) parameterEntry;
					batchSqlUpdate.update(parametersValues);
				}
				batchSqlUpdate.flush();

			} catch (DataAccessException e) {

				throw new RuntimeException("Error", e);
			}
		}

		return resultado;
	}

}
