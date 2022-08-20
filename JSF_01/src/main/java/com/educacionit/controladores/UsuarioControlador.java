package com.educacionit.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.educacionit.modelos.Usuario;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ManagedBean
@RequestScoped
public class UsuarioControlador {
	private static Logger logger = LogManager.getLogger();
	private Usuario usuario = new Usuario();
	private static List<Usuario> usuarios = new ArrayList<Usuario>();

	public UsuarioControlador() {
		logger.info("Se ha construido correctamente el " + this.getClass().getSimpleName());
		logger.debug(usuarios);
	}

	public String agregarUsuario() {
		usuarios.add(usuario);

		logger.debug(usuarios);
		return "usuarios";
	}

	public String eliminarUsuario(Usuario usuario) {
		usuarios.remove(usuario);
		logger.debug(usuarios);
		return "usuarios";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public static List<Usuario> getUsuarios() {
		return usuarios;
	}

	public static void setUsuarios(List<Usuario> usuarios) {
		UsuarioControlador.usuarios = usuarios;
	}

}
