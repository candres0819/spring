package com.projectbase.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.projectbase.dao.model.UsuarioSesion;

/**
 * Clase utilizada para realizar el mapeo del resultado de la consulta a base de
 * datos.
 * 
 * @author carlos.cardona [19/12/2013]
 */
@SuppressWarnings("rawtypes")
public class UsuarioSesionRMI implements RowMapper {

	public Object mapRow(final ResultSet result, final int rowNumber) throws SQLException {

		final UsuarioSesion usuarioSesion = new UsuarioSesion();

		usuarioSesion.setIdPermiso(result.getInt("idPermiso"));
		usuarioSesion.setIdRol(result.getInt("idRol"));
		usuarioSesion.setIdUsuario(result.getInt("idUsuario"));
		usuarioSesion.setLogin((null == result.getString("login")) ? "" : result.getString("login").trim());

		return usuarioSesion;

	}

}
