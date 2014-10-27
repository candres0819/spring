package com.projectbase.dao;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Repository;

import com.projectbase.dao.exec.sql.MappingSqlQueryServicio;
import com.projectbase.dao.exec.sql.SqlInsertServicio;
import com.projectbase.dao.model.AdmonCentrosCostos;
import com.projectbase.dao.model.CargaSelects;
import com.projectbase.dao.model.Equipo;
import com.projectbase.dao.model.FinPYG;
import com.projectbase.dao.model.Informacion;
import com.projectbase.dao.model.LlamadoPYG;
import com.projectbase.dao.model.PermisosUsuario;
import com.projectbase.dao.model.UltimoPYG;
import com.projectbase.dao.model.UsuarioSesion;
import com.projectbase.dao.rowmapper.AdmonCentrosCostosRMI;
import com.projectbase.dao.rowmapper.CargaSelectsRMI;
import com.projectbase.dao.rowmapper.EquipoRMI;
import com.projectbase.dao.rowmapper.LlamadoPYGRMI;
import com.projectbase.dao.rowmapper.UltimoPYGRMI;
import com.projectbase.dao.rowmapper.UsuarioSesionRMI;
import com.projectbase.dao.rowmapper.ValorPYGRMI;

@Repository
@Scope("singleton")
public class ProjectBaseDAOImpl implements ProjectBaseDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private String sqlConsultarUsuario;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.com.proteccion.comun.servicioscorelegacy.dao.ServiciosCoreLegacyDAO
	 * #consultarHoraCierre(java.lang.String)
	 */
	public UsuarioSesion consultarUsuario(String login) {
		this.sqlConsultarUsuario = "select e.id_persona as idUsuario, b.id_rol as idRol, c.id_permiso as idPermiso, e.usuario as login from SEG_PERSONAS_ROLES a"
				+ "	join SEG_ROLES b on a.ID_ROL = b.ID_ROL join SEG_ROLES_PERMISOS c on b.id_rol = c.id_rol"
				+ "	join SEG_PERMISOS d on c.id_permiso = d.id_permiso join ADM_PERSONAS_NAT_Y_JUR e on a.id_persona = e.id_persona"
				+ " where e.usuario = ?;";

		final LinkedList<SqlParameter> parametros = new LinkedList<SqlParameter>();
		parametros.add(new SqlParameter("eusuario", Types.VARCHAR));

		final LinkedHashMap<String, Object> valorParametros = new LinkedHashMap<String, Object>();
		valorParametros.put("eusuario", login);

		final MappingSqlQueryServicio mappingSqlQuery = new MappingSqlQueryServicio(this.jdbcTemplate, this.sqlConsultarUsuario,
				parametros, valorParametros, new UsuarioSesionRMI());

		List<Object> resultado = mappingSqlQuery.executeQuery();

		if (null != resultado && !resultado.isEmpty()) {
			UsuarioSesion usarioRetorno = (UsuarioSesion) resultado.get(0);
			List<PermisosUsuario> permisos = new ArrayList<PermisosUsuario>();
			PermisosUsuario permiso = null;
			for (Object user : resultado) {
				UsuarioSesion usuario = (UsuarioSesion) user;
				permiso = new PermisosUsuario();
				permiso.setIdPermiso(usuario.getIdPermiso());
				if (1 == usuario.getIdPermiso()) {
					permiso.setNombrePermiso("Exportador");
				} else if (2 == usuario.getIdPermiso()) {
					permiso.setNombrePermiso("Validaciones");
				} else if (3 == usuario.getIdPermiso()) {
					permiso.setNombrePermiso("AplicacionCostos");
				} else if (4 == usuario.getIdPermiso()) {
					permiso.setNombrePermiso("BorrarMovimientos");
				} else if (6 == usuario.getIdPermiso()) {
					permiso.setNombrePermiso("CentrosCostos");
				} else if (7 == usuario.getIdPermiso()) {
					permiso.setNombrePermiso("presupuesto");
				} else if (5 == usuario.getIdPermiso()) {
					permiso.setNombrePermiso("PYG");
				}
				permisos.add(permiso);
			}
			usarioRetorno.setPermisos(permisos);
			usarioRetorno.setIdPermiso(null);
			return usarioRetorno;
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.pragma.pyg.dao.PyGCOREDAO#exeQueryBorrado(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	public void exeQueryBorrado(String mes, String anyo, String query) throws SQLException {
		final LinkedList<SqlParameter> parametros = new LinkedList<SqlParameter>();
		parametros.add(new SqlParameter("mes", Types.VARCHAR));
		parametros.add(new SqlParameter("anyo", Types.VARCHAR));

		Object[] objeto = new Object[2];

		objeto[0] = anyo;
		objeto[1] = mes;

		SqlInsertServicio sqlUpdate = new SqlInsertServicio(this.jdbcTemplate, query, parametros);

		final LinkedList<Object[]> valoresParametros = new LinkedList<Object[]>();

		valoresParametros.add(objeto);
		sqlUpdate.executeQueries(valoresParametros);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.pragma.pyg.dao.PyGCOREDAO#equipoById(java.lang.String)
	 */
	public Equipo equipo(String id, String nombre) {
		String query = "";
		String param = "";
		if (null != id) {
			query = "SELECT ID_EQUIPO as idEquipo, NOMBRE_EQUIPO as nombreEquipo,"
					+ "ID_PERSONA_DIRECTOR as idPersonaDirector, ID_UEN as idUen, APLICA_PYG as aplicaPYG, ESTADO as estado "
					+ " FROM ADM_EQUIPOS WHERE ID_EQUIPO = ?";
			param = id;
		} else if (null != nombre) {
			query = "SELECT ID_EQUIPO as idEquipo, NOMBRE_EQUIPO as nombreEquipo,"
					+ "ID_PERSONA_DIRECTOR as idPersonaDirector, ID_UEN as idUen, APLICA_PYG as aplicaPYG, ESTADO as estado "
					+ " FROM ADM_EQUIPOS WHERE NOMBRE_EQUIPO = ?";
			param = nombre;
		}

		final LinkedList<SqlParameter> parametros = new LinkedList<SqlParameter>();
		parametros.add(new SqlParameter("param", Types.VARCHAR));

		final LinkedHashMap<String, Object> valorParametros = new LinkedHashMap<String, Object>();
		valorParametros.put("param", param);

		final MappingSqlQueryServicio mappingSqlQuery = new MappingSqlQueryServicio(this.jdbcTemplate, query, parametros, valorParametros,
				new EquipoRMI());

		List<Object> resultado = mappingSqlQuery.executeQuery();
		if (null != resultado && !resultado.isEmpty()) {
			return (Equipo) resultado.get(0);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.com.pragma.pyg.dao.PyGCOREDAO#insertarPresupuesto(java.lang.Integer,
	 * java.lang.Integer, java.lang.Integer, java.lang.Double,
	 * java.lang.Integer, java.lang.Integer, java.lang.String)
	 */
	public void insertarPresupuesto(Integer fecha1, Integer fecha2, Integer tipoMovimiento, Double valor, Integer id, Integer tipo,
			String tipoPresupuesto) {
		String query = "";
		if ("junta".equals(tipoPresupuesto)) {
			query = "INSERT INTO ADM_PRESUPUESTO_JUNTA VALUES (?, ?, ?, ?, ?, ?)";
		} else {
			query = "INSERT INTO ADM_PRESUPUESTO VALUES (?, ?, ?, ?, ?, ?)";
		}
		final LinkedList<SqlParameter> parametros = new LinkedList<SqlParameter>();
		parametros.add(new SqlParameter("fecha1", Types.INTEGER));
		parametros.add(new SqlParameter("fecha2", Types.INTEGER));
		parametros.add(new SqlParameter("tipoMovimiento", Types.INTEGER));
		parametros.add(new SqlParameter("valor", Types.DOUBLE));
		parametros.add(new SqlParameter("id", Types.INTEGER));
		parametros.add(new SqlParameter("tipo", Types.INTEGER));

		Object[] objeto = new Object[6];

		objeto[0] = fecha1;
		objeto[1] = fecha2;
		objeto[2] = tipoMovimiento;
		objeto[3] = valor;
		objeto[4] = id;
		objeto[5] = tipo;

		SqlInsertServicio sqlUpdate = new SqlInsertServicio(this.jdbcTemplate, query, parametros);

		final LinkedList<Object[]> valoresParametros = new LinkedList<Object[]>();

		valoresParametros.add(objeto);
		sqlUpdate.executeQueries(valoresParametros);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.pragma.pyg.dao.PyGCOREDAO#equipoById(java.lang.String)
	 */
	public List<AdmonCentrosCostos> centroCostos(String query) {
		final LinkedList<SqlParameter> parametros = new LinkedList<SqlParameter>();

		final LinkedHashMap<String, Object> valorParametros = new LinkedHashMap<String, Object>();

		final MappingSqlQueryServicio mappingSqlQuery = new MappingSqlQueryServicio(this.jdbcTemplate, query, parametros, valorParametros,
				new AdmonCentrosCostosRMI());

		List<Object> resultado = mappingSqlQuery.executeQuery();
		if (null != resultado && !resultado.isEmpty()) {
			List<AdmonCentrosCostos> listCentroCostos = new ArrayList<AdmonCentrosCostos>();
			for (Object result : resultado) {
				listCentroCostos.add((AdmonCentrosCostos) result);
			}
			return listCentroCostos;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.com.pragma.pyg.dao.PyGCOREDAO#insertarPresupuesto(java.lang.Integer,
	 * java.lang.Integer, java.lang.Integer, java.lang.Double,
	 * java.lang.Integer, java.lang.Integer, java.lang.String)
	 */
	public void crearActualizar(String query, final LinkedList<SqlParameter> parametros, Object[] objeto) {

		SqlInsertServicio sqlUpdate = new SqlInsertServicio(this.jdbcTemplate, query, parametros);

		final LinkedList<Object[]> valoresParametros = new LinkedList<Object[]>();

		valoresParametros.add(objeto);
		sqlUpdate.executeQueries(valoresParametros);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.pragma.pyg.dao.PyGCOREDAO#equipoById(java.lang.String)
	 */
	public List<CargaSelects> cargaSelect(String query, final LinkedList<SqlParameter> parametros,
			final LinkedHashMap<String, Object> valorParametros) {

		final MappingSqlQueryServicio mappingSqlQuery = new MappingSqlQueryServicio(this.jdbcTemplate, query, parametros, valorParametros,
				new CargaSelectsRMI());

		List<Object> resultado = mappingSqlQuery.executeQuery();
		if (null != resultado && !resultado.isEmpty()) {
			List<CargaSelects> listCargaSelects = new ArrayList<CargaSelects>();
			for (Object result : resultado) {
				listCargaSelects.add((CargaSelects) result);
			}
			return listCargaSelects;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.pragma.pyg.dao.PyGCOREDAO#equipoById(java.lang.String)
	 */
	public List<UltimoPYG> ultimoPYG(String query, final LinkedList<SqlParameter> parametros,
			final LinkedHashMap<String, Object> valorParametros) {

		final MappingSqlQueryServicio mappingSqlQuery = new MappingSqlQueryServicio(this.jdbcTemplate, query, parametros, valorParametros,
				new UltimoPYGRMI());

		List<Object> resultado = mappingSqlQuery.executeQuery();
		if (null != resultado && !resultado.isEmpty()) {
			List<UltimoPYG> listUltimoPYG = new ArrayList<UltimoPYG>();
			for (Object result : resultado) {
				listUltimoPYG.add((UltimoPYG) result);
			}
			return listUltimoPYG;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.pragma.pyg.dao.PyGCOREDAO#equipoById(java.lang.String)
	 */
	public List<LlamadoPYG> llamadoPYG(String query, final LinkedList<SqlParameter> parametros,
			final LinkedHashMap<String, Object> valorParametros) {

		final MappingSqlQueryServicio mappingSqlQuery = new MappingSqlQueryServicio(this.jdbcTemplate, query, parametros, valorParametros,
				new LlamadoPYGRMI());

		List<Object> resultado = mappingSqlQuery.executeQuery();
		if (null != resultado && !resultado.isEmpty()) {
			List<LlamadoPYG> listLlamadoPYG = new ArrayList<LlamadoPYG>();
			LlamadoPYG llamadoPYG = new LlamadoPYG();
			for (Object result : resultado) {
				FinPYG finPYG = (FinPYG) result;
				switch (finPYG.getIdTipoMovimiento()) {
				case 1:
					llamadoPYG.setSalarios(finPYG.getValor());
					break;
				case 14:
					llamadoPYG.setIngresos(finPYG.getValor());
					break;
				case 8:
					llamadoPYG.setImasdUEN(finPYG.getValor());
					break;
				case 6:
					llamadoPYG.setAdmonUen(finPYG.getValor());
					break;
				case 10:
					llamadoPYG.setAdei(finPYG.getValor());
					break;
				case 7:
					llamadoPYG.setComercialUEN(finPYG.getValor());
					break;
				case 2:
					llamadoPYG.setCompras(finPYG.getValor());
					break;
				case 15:
					llamadoPYG.setCostosDirectos(finPYG.getValor());
					break;
				case 5:
					llamadoPYG.setDiversos(finPYG.getValor());
					break;
				case 4:
					llamadoPYG.setEquiposComputo(finPYG.getValor());
					break;
				case 19:
					llamadoPYG.setGaf(finPYG.getValor());
					break;
				case 22:
					llamadoPYG.setNpDirectas(finPYG.getValor());
					break;
				case 23:
					llamadoPYG.setNpUEN(finPYG.getValor());
					break;
				case 24:
					llamadoPYG.setNpGAF(finPYG.getValor());
					break;
				case 25:
					llamadoPYG.setNpTotal(finPYG.getValor());
					break;
				case 9:
					llamadoPYG.setPmo(finPYG.getValor());
					break;
				case 16:
					llamadoPYG.setUtilidadDirecta(finPYG.getValor());
					break;
				case 3:
					llamadoPYG.setGastosViajes(finPYG.getValor());
					break;
				case 33:
					llamadoPYG.setIngresosServicios(finPYG.getValor());
					break;
				case 32:
					llamadoPYG.setIngresosLicencias(finPYG.getValor());
					break;
				case 34:
					llamadoPYG.setSalariosAdmonUEN(finPYG.getValor());
					break;
				case 35:
					llamadoPYG.setOtrosAdmonUEN(finPYG.getValor());
					break;
				case 36:
					llamadoPYG.setSalariosComercialUEN(finPYG.getValor());
					break;
				case 37:
					llamadoPYG.setOtrosComercialUEN(finPYG.getValor());
					break;
				case 38:
					llamadoPYG.setSalariosImasdUEN(finPYG.getValor());
					break;
				case 39:
					llamadoPYG.setOtrosImasDUEN(finPYG.getValor());
					break;
				case 40:
					llamadoPYG.setSalariosGAF(finPYG.getValor());
					break;
				case 41:
					llamadoPYG.setOtrosGAF(finPYG.getValor());
					break;
				case 42:
					llamadoPYG.setSalariosPMO(finPYG.getValor());
					break;
				case 43:
					llamadoPYG.setOtrosPMO(finPYG.getValor());
					break;
				case 44:
					llamadoPYG.setPersonasAdmonUEN(finPYG.getValor());
					break;
				case 45:
					llamadoPYG.setPersonasComercialUEN(finPYG.getValor());
					break;
				case 46:
					llamadoPYG.setPersonasImasDUEN(finPYG.getValor());
					break;
				case 47:
					llamadoPYG.setPersonasPMO(finPYG.getValor());
					break;
				}
			}
			if (null != llamadoPYG.getGastosViajes() && 0 != llamadoPYG.getGastosViajes().compareTo(BigDecimal.ZERO)) {
				BigDecimal diversos = llamadoPYG.getDiversos();
				llamadoPYG.setDiversos(diversos.add(llamadoPYG.getGastosViajes()));
			}
			if (null != llamadoPYG.getEquiposComputo() && 0 != llamadoPYG.getEquiposComputo().compareTo(BigDecimal.ZERO)) {
				BigDecimal equiposComputo = llamadoPYG.getEquiposComputo();
				llamadoPYG.setDiversos(equiposComputo.add(llamadoPYG.getDiversos()));
			}
			llamadoPYG.setCostosUEN(llamadoPYG.getAdmonUen().add(llamadoPYG.getComercialUEN().add(llamadoPYG.getImasdUEN())));
			llamadoPYG.setUtilidadDA(llamadoPYG.getUtilidadDirecta().add(llamadoPYG.getCostosUEN()));
			llamadoPYG.setUtilidadAI(llamadoPYG.getUtilidadDA().add(llamadoPYG.getGaf()).add(llamadoPYG.getPmo()));
			llamadoPYG.setEbitda(llamadoPYG.getUtilidadAI().subtract(llamadoPYG.getAdei()));

			if (0 == llamadoPYG.getEbitda().compareTo(BigDecimal.ZERO) && 0 == llamadoPYG.getIngresos().compareTo(BigDecimal.ZERO)) {
				llamadoPYG = null;
			}
			listLlamadoPYG.add(llamadoPYG);
			return listLlamadoPYG;

		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.pragma.pyg.dao.PyGCOREDAO#equipoById(java.lang.String)
	 */
	public List<BigDecimal> valor(String query, final LinkedList<SqlParameter> parametros,
			final LinkedHashMap<String, Object> valorParametros) {

		final MappingSqlQueryServicio mappingSqlQuery = new MappingSqlQueryServicio(this.jdbcTemplate, query, parametros, valorParametros,
				new ValorPYGRMI());

		List<Object> resultado = mappingSqlQuery.executeQuery();
		if (null != resultado && !resultado.isEmpty()) {
			List<BigDecimal> listValor = new ArrayList<BigDecimal>();
			for (Object result : resultado) {
				listValor.add((BigDecimal) result);
			}
			return listValor;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.pragma.pyg.dao.PyGCOREDAO#equipoById(java.lang.String)
	 */
	public List<Informacion> informacion(String query, final LinkedList<SqlParameter> parametros,
			final LinkedHashMap<String, Object> valorParametros) {

		final MappingSqlQueryServicio mappingSqlQuery = new MappingSqlQueryServicio(this.jdbcTemplate, query, parametros, valorParametros,
				new UltimoPYGRMI());

		List<Object> resultado = mappingSqlQuery.executeQuery();
		if (null != resultado && !resultado.isEmpty()) {
			List<Informacion> informacion = new ArrayList<Informacion>();
			for (Object result : resultado) {
				informacion.add((Informacion) result);
			}
			return informacion;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.pragma.pyg.dao.PyGCOREDAO#getDivision(java.lang.String,
	 * java.lang.String)
	 */
	public BigDecimal getDivision(String year, String mes) {
		String query = "select sum((a.EGRESOS-a.INGRESOS)* f.PORCENTAJE_TIEMPO) as valor from FIN_MOVIMIENTOS_CONTABLES a"
				+ "  join FIN_TIEMPOS_PERSONAS f on a.ID_PERSONA = f.ID_PERSONA"
				+ "  join CTA_CUENTAS_SUBAUXILIARES b on a.ID_CUENTA_SUBAUXILIAR = b.ID_CUENTA_SUBAUXILIAR"
				+ "  join CTA_CUENTAS_AUXILIARES c on b.ID_CUENTA_AUXILIAR = c.ID_CUENTA_AUXILIAR"
				+ "  join CTA_CUENTAS d on c.ID_CUENTA = d.ID_CUENTA join ADM_EQUIPOS h on f.ID_EQUIPO = h.ID_EQUIPO "
				+ " where d.CODIGO_CUENTA = '5105' and (YEAR(a.fecha) = " + year + " and MONTH(a.fecha) = " + mes + ") and (f.ANYO=" + year
				+ " and f.MES=" + mes + ");";

		LinkedList<SqlParameter> parametros = new LinkedList<SqlParameter>();

		LinkedHashMap<String, Object> valorParametros = new LinkedHashMap<String, Object>();

		return valor(query, parametros, valorParametros).get(0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.pragma.pyg.dao.PyGCOREDAO#getDivisionD(java.lang.String,
	 * java.lang.String)
	 */
	public BigDecimal getDivisionD(String year, String mes) {
		return getDivision(year, mes);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.pragma.pyg.dao.PyGCOREDAO#getTotalHardware(java.lang.String,
	 * java.lang.String)
	 */
	public BigDecimal getTotalHardware(String mes, String year) {

		String queryTotal = "select sum(a.egresos) as valor from FIN_MOVIMIENTOS_CONTABLES a where a.id_tipo_movimiento_aplicado = 4 and "
				+ "(YEAR(a.fecha) = " + year + " AND MONTH(a.fecha) = " + mes + "); ";
		LinkedList<SqlParameter> parametros = new LinkedList<SqlParameter>();

		LinkedHashMap<String, Object> valorParametros = new LinkedHashMap<String, Object>();

		return valor(queryTotal, parametros, valorParametros).get(0);
	}
}
