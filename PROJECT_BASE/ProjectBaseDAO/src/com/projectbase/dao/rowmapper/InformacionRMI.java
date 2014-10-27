package com.projectbase.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.projectbase.dao.model.Informacion;

/**
 * Clase utilizada para realizar el mapeo del resultado de la consulta a base de
 * datos.
 * 
 * @author carlos.cardona [19/12/2013]
 */
@SuppressWarnings("rawtypes")
public class InformacionRMI implements RowMapper {

	public Object mapRow(final ResultSet result, final int rowNumber) throws SQLException {

		final Informacion informacion = new Informacion();

		informacion.setIdMovimiento(result.getInt("a.id_movimiento_contable"));
		informacion.setValor(result.getBigDecimal("VALOR"));
		informacion.setIdUen(result.getInt("c.ID_UEN"));
		informacion.setUenAplicaPYG(result.getInt("aplica1"));
		informacion.setIdLinea(result.getInt("d.ID_LINEA"));
		informacion.setLineaAplicaPYG(result.getInt("aplica2"));
		informacion.setIdCliente(result.getInt("e.CODIGO_CENTRO_COSTOS"));
		informacion.setClienteAplicaPYG(result.getInt("aplica3"));
		informacion.setIdContrato(result.getInt("f.ID_CONTRATO"));
		informacion.setContratoAplicaPYG(result.getInt("aplica4"));
		informacion.setIdRegion(result.getInt("R.ID_REGION"));
		informacion.setRegionAplicaPYG(result.getInt("aplica5"));

		return informacion;
	}

}
