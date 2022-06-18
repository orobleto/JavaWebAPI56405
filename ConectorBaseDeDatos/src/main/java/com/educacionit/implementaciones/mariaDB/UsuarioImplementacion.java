package com.educacionit.implementaciones.mariaDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.educacionit.entidades.Usuario;
import com.educacionit.intefaces.DAO;
import com.educacionit.intefaces.MariaDB;
import com.educacionit.utilidades.Fechas;

public class UsuarioImplementacion implements DAO<String, Usuario>, MariaDB {
	private PreparedStatement psInsertar;
	private PreparedStatement psModificar;
	private PreparedStatement psEliminar;
	private PreparedStatement psBuscarPorId;
	private PreparedStatement psListar;

	@Override
	public boolean insertar(Usuario usuario) {
		String query = "insert into usuarios (correo,clave,fechaCreacion,fechaModificacion) values (?,AES_ENCRYPT(?,?),?,?)";
		try {
			if (null == psInsertar) {
				psInsertar = getConexion().prepareStatement(query);
			}

			psInsertar.setString(1, usuario.getCorreo());
			psInsertar.setString(2, usuario.getClave());
			psInsertar.setString(3, getKEY());
			psInsertar.setString(4, Fechas.getStringLocalDate(usuario.getFechaCreacion()));
			psInsertar.setString(5, Fechas.getStringLocalDateTime(usuario.getFechaModificacion()));

			return psInsertar.executeUpdate() == 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean modificar(Usuario usuario) {
		return false;
	}

	@Override
	public boolean eliminar(Usuario usuario) {
		return false;
	}

	@Override
	public Usuario buscarPorId(String correo) {
		Usuario usuario = null;
		String query = "select AES_DECRYPT(clave,?) as clave, fechaCreacion,fechaModificacion from usuarios where correo = ?";

		try {
			if (null == psBuscarPorId) {
				psBuscarPorId = getConexion().prepareStatement(query);
			}

			psBuscarPorId.setString(1, getKEY());
			psBuscarPorId.setString(2, correo);

			ResultSet resultSet = psBuscarPorId.executeQuery();

			if (resultSet.next()) {
				usuario = new Usuario();
				usuario.setCorreo(correo);
				usuario.setClave(resultSet.getString("clave"));
				usuario.setFechaCreacion(Fechas.getLocalDate(resultSet.getString("fechaCreacion")));
				usuario.setFechaModificacion(Fechas.getLocalDateTime(resultSet.getString("fechaModificacion")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuario;
	}

	@Override
	public List<Usuario> listar() {
		return null;
	}

}
