package com.educacionit.interfaces;

import java.util.List;

import com.educacionit.DTOs.UsuarioDTO;
import com.educacionit.entidades.Usuario;

public interface IUsuario {

	UsuarioDTO guardar(Usuario usuario);

	UsuarioDTO eliminar(Usuario usuario);

	UsuarioDTO buscar(String correo);

	List<UsuarioDTO> listar();

	List<UsuarioDTO> agregarTodos(List<Usuario> usuarios);

	UsuarioDTO fromUsuario(Usuario usuario, String mensaje);

	Usuario fromUsuarioDTO(UsuarioDTO usuarioDTO);
}
