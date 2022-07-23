package com.educacionit.implementaciones.mariaDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
		// lanzo excepcion
		String query = "insert into usuarios (correo,clave,fechaCreacion,fechaModificacion) values (?,AES_ENCRYPT(?,?),?,?)";
		try {
			if (null == psInsertar) {
				psInsertar = getConexion().prepareStatement(query);
			}

			psInsertar.setString(1, usuario.getCorreo());
			psInsertar.setString(2, usuario.getClave());
			psInsertar.setString(3, getKEY());
			psInsertar.setString(4, Fechas.getStringLocalDate(LocalDate.now()));
			psInsertar.setString(5, Fechas.getStringLocalDateTime(LocalDateTime.now()));

			return psInsertar.executeUpdate() == 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean modificar(Usuario usuario) {
		String query = "update usuarios set clave = AES_ENCRYPT(?,?), fechaModificacion = ?  where correo = ?";
		try {
			if (null == psModificar) {
				psModificar = getConexion().prepareStatement(query);
			}

			psModificar.setString(1, usuario.getClave());
			psModificar.setString(2, getKEY());
			psModificar.setString(3, Fechas.getStringLocalDateTime(LocalDateTime.now()));
			psModificar.setString(4, usuario.getCorreo());

			return psModificar.executeUpdate() == 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean eliminar(Usuario usuario) {

		String query = "delete from usuarios where correo = ?";
		try {
			if (null == psEliminar) {
				psEliminar = getConexion().prepareStatement(query);
			}
			psEliminar.setString(1, usuario.getCorreo());

			return psEliminar.executeUpdate() == 1; // 0 1 si no lo eliminio

		} catch (SQLException e) {
			e.printStackTrace();
		}
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
		List<Usuario> usuarios = new ArrayList<>();
		String query = "select correo, AES_DECRYPT(clave,?) as clave, fechaCreacion,fechaModificacion from usuarios";

		try {
			if (null == psListar) {
				psListar = getConexion().prepareStatement(query);
			}
			psListar.setString(1, getKEY());

			ResultSet resultSet = psListar.executeQuery();

			while (resultSet.next()) {
				Usuario usuario = new Usuario();
				usuario.setCorreo(resultSet.getString("correo"));
				usuario.setClave(resultSet.getString("clave"));
				usuario.setFechaCreacion(Fechas.getLocalDate(resultSet.getString("fechaCreacion")));
				usuario.setFechaModificacion(Fechas.getLocalDateTime(resultSet.getString("fechaModificacion")));
				usuarios.add(usuario);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuarios;
	}

}
