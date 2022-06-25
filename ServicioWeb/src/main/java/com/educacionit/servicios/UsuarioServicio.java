package com.educacionit.servicios;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.educacionit.dtos.UsuarioDTO;
import com.educacionit.entidades.Usuario;
import com.educacionit.implementaciones.mariaDB.UsuarioImplementacion;
import com.educacionit.utilidades.Fechas;

@WebService(name = "UsuarioServicio", portName = "ServicioDeUsuarios", targetNamespace = "http://educacionit.com")
public class UsuarioServicio {
	private UsuarioImplementacion usuarioImplementacion = new UsuarioImplementacion();

	@WebMethod(operationName = "buscarUsuario")
	@WebResult(name = "usuario", header = true)
	public UsuarioDTO buscarEntidad(@WebParam(name = "correoUsuario") String correo) {

		return usuarioDTOFromUsuario(usuarioImplementacion.buscarPorId(correo));
	}

	@WebMethod(operationName = "modificarUsuario")
	@WebResult(name = "usuario", header = true)
	public UsuarioDTO modificarEntidad(@WebParam(name = "usuario") UsuarioDTO usuarioDTO) {
		usuarioImplementacion.modificar(usuarioFromDTO(usuarioDTO));
		return usuarioDTOFromUsuario(usuarioImplementacion.buscarPorId(usuarioDTO.getCorreo()));
	}

	@WebMethod(operationName = "insertarUsuario")
	@WebResult(name = "usuario", header = true)
	public UsuarioDTO insertarEntidad(@WebParam(name = "usuario") UsuarioDTO usuarioDTO) {
		usuarioImplementacion.insertar(usuarioFromDTO(usuarioDTO));
		return usuarioDTOFromUsuario(usuarioImplementacion.buscarPorId(usuarioDTO.getCorreo()));
	}

	@WebMethod(operationName = "eliminarUsuario")
	@WebResult(name = "usuarioEliminado", header = true)
	public Boolean eliminarEntidad(UsuarioDTO usuarioDTO) {
		return usuarioImplementacion.eliminar(usuarioFromDTO(usuarioDTO));
	}

	@WebMethod(operationName = "listarUsuarios")
	@WebResult(name = "usuarios", header = true)
	public UsuarioDTO[] listarEntidad() {

		List<Usuario> lista = usuarioImplementacion.listar();
		UsuarioDTO[] usuarios = new UsuarioDTO[lista.size()];
		for (int i = 0; i < lista.size(); i++) {
			usuarios[i] = usuarioDTOFromUsuario(lista.get(i));

		}
		return usuarios;
	}

	private Usuario usuarioFromDTO(UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario();
		usuario.setCorreo(usuarioDTO.getCorreo());
		usuario.setClave(usuarioDTO.getClave());
		usuario.setFechaCreacion(Fechas.getLocalDate(usuarioDTO.getFechaCreacion()));
		usuario.setFechaModificacion(Fechas.getLocalDateTime(usuarioDTO.getFechaModificacion()));
		return usuario;
	}

	private UsuarioDTO usuarioDTOFromUsuario(Usuario usuario) {
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setCorreo(usuario.getCorreo());
		usuarioDTO.setClave(usuario.getClave());
		usuarioDTO.setFechaCreacion(Fechas.getStringLocalDate(usuario.getFechaCreacion()));
		usuarioDTO.setFechaModificacion(Fechas.getStringLocalDateTime(usuario.getFechaModificacion()));
		return usuarioDTO;
	}

}
