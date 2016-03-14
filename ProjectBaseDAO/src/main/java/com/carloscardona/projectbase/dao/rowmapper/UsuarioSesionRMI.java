package com.carloscardona.projectbase.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.carloscardona.projectbase.dao.model.UsuarioSesion;

/**
 * Clase utilizada para realizar el mapeo del resultado de la consulta a base de
 * datos.
 * 
 * @author carlos.cardona
 */
@SuppressWarnings("rawtypes")
public class UsuarioSesionRMI implements RowMapper {

	public Object mapRow(final ResultSet result, final int rowNumber) throws SQLException {

		final UsuarioSesion usuarioSesion = new UsuarioSesion();

		usuarioSesion.setId(result.getInt("id"));
		usuarioSesion.setNombre((null == result.getString("nombre")) ? "" : result.getString("nombre").trim());
		usuarioSesion.setLogin((null == result.getString("login")) ? "" : result.getString("login").trim());

		return usuarioSesion;
	}

}
