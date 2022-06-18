package com.educacionit.implementaciones.mariaDB;

import java.sql.PreparedStatement;
import java.util.List;

import com.educacionit.entidades.Usuario;
import com.educacionit.intefaces.DAO;

public class UsuarioImplementacion implements DAO<String, Usuario> {
	private PreparedStatement psInsertar;
	private PreparedStatement psModificar;
	private PreparedStatement psEliminar;
	private PreparedStatement psBuscarPorId;
	private PreparedStatement psListar;

	@Override
	public boolean insertar(Usuario usuario) {
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
		return null;
	}

	@Override
	public List<Usuario> listar() {
		return null;
	}

}
