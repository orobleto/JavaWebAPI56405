package com.educacionit.servicios;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.educacionit.DTOs.ErrorDTO;
import com.educacionit.DTOs.UsuarioDTO;
import com.educacionit.entidades.Usuario;
import com.educacionit.implementaciones.mariaDB.UsuarioImplementacion;
import com.educacionit.interfaces.IUsuario;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioServicio implements IUsuario {

	private UsuarioImplementacion usuarioImplementacion = new UsuarioImplementacion();

	@GET
	@Path("/listar")
	public List<UsuarioDTO> listar() {
		// API Stream map filter y reduce
		List<UsuarioDTO> usuariosDTO = usuarioImplementacion.listar().stream()
				.map(usuario -> fromUsuario(usuario, null)).collect(Collectors.toList());
		return usuariosDTO;
	}

	@PUT
	@Path("/guardarJSON")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response guardar(UsuarioDTO usuarioDTO) {
		return Response.status(Status.CREATED).entity(guardar(fromUsuarioDTO(usuarioDTO))).build();
	}

	@POST
	@Path("/guardarForm")
	public Response guardar(@FormParam("correo") String correo, @FormParam("clave") String clave) {
		Usuario usuario = new Usuario();
		usuario.setCorreo(correo);
		usuario.setClave(clave);

		return Response.status(Status.CREATED).entity(guardar(usuario)).build();
	}

	public UsuarioDTO guardar(Usuario usuario) {
		String mensaje = "Se ha creado el registro exitosamente";
		if (usuarioImplementacion.buscarPorId(usuario.getCorreo()) == null) {
			usuarioImplementacion.insertar(usuario);
		} else {
			usuarioImplementacion.modificar(usuario);
			mensaje = "Se ha modificado el registro exitosamente";
		}
		return fromUsuario(usuarioImplementacion.buscarPorId(usuario.getCorreo()), mensaje);
	}

	@DELETE
	@Path("/eliminar")
	public Response elimiar(UsuarioDTO usuarioDTO) {
		Usuario usuario = usuarioImplementacion.buscarPorId(usuarioDTO.getCorreo());
		if (usuario != null) {
			usuarioImplementacion.eliminar(usuario);
			return Response.status(200).entity(fromUsuario(usuario, "Registro eliminado correctamente")).build();
		}
		ErrorDTO error = new ErrorDTO("ERROR01", usuarioDTO + " NO Encontrado");
		return Response.status(200).entity(error).build();
	}

	public UsuarioDTO eliminar(Usuario usuario) {

		return null;
	}

	@GET
	@Path("/buscar/{correo}")
	public UsuarioDTO buscarPorPath(@PathParam("correo") String correo) {
		return buscar(correo);
	}

	@GET
	@Path("buscarQ")
	public Response buscarPorQuery(@QueryParam("correo") String correo) {
		UsuarioDTO usuarioDTO = buscar(correo);
		int status = 203;
		ErrorDTO error = new ErrorDTO("ERROR01", "Usuario con el correo: " + correo + " NO Encontrado");

		if (usuarioDTO != null) {
			status = 200;
			return Response.status(status).entity(usuarioDTO).build();
		}

		return Response.status(status).entity(error).build();
	}

	@Override
	public UsuarioDTO buscar(String correo) {
		return fromUsuario(usuarioImplementacion.buscarPorId(correo), "Encontrado correctamente");
	}

	public List<UsuarioDTO> agregarTodos(List<Usuario> usuarios) {
		return null;
	}

	public UsuarioDTO fromUsuario(Usuario usuario, String mensaje) {
		UsuarioDTO usuarioDTO = null;
		if (usuario != null) {
			usuarioDTO = new UsuarioDTO();
			usuarioDTO.setCorreo(usuario.getCorreo());
			usuarioDTO.setClave(usuario.getClave());
			usuarioDTO.setFechaCreacion(usuario.getFechaCreacion());
			usuarioDTO.setFechaModificacion(usuario.getFechaModificacion());
			usuarioDTO.setMensaje(mensaje);
			return usuarioDTO;
		}
		return usuarioDTO;
	}

	public Usuario fromUsuarioDTO(UsuarioDTO usuarioDTO) {
		Usuario usuario = null;
		if (usuarioDTO != null) {
			usuario = new Usuario();
			usuario.setCorreo(usuarioDTO.getCorreo());
			usuario.setClave(usuarioDTO.getClave());
			usuario.setFechaCreacion(usuarioDTO.getFechaCreacion());
			usuario.setFechaModificacion(usuarioDTO.getFechaModificacion());
		}
		return usuario;
	}

	@GET
	@Path("/listarNombres")
	public List<String> listaString() {
		return Arrays.asList("Octavio", "Santiago");
	}

	@GET
	@Path("/headerHTTP")
	public Response getHeader(@HeaderParam(value = "Host") String host) {
		try {
			System.out.println(host);
			return Response.seeOther(new URI("http://127.0.0.1:5500/index.html")).build();
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}

	@GET
	@Path("/headersHTTP")
	public Response getHeaders() {
		for (Entry<String, List<String>> entry : headers.getRequestHeaders().entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		return Response.ok().build();
	}

	@POST
	@Path("/guardarConCabecera")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response guardarCC(@HeaderParam("USER-ID") String userID, UsuarioDTO usuarioDTO) {
		List<Object> objetos = Arrays.asList(guardar(fromUsuarioDTO(usuarioDTO)), userID);
		return Response.status(Status.CREATED).entity(objetos).build();
	}

	@Context
	HttpHeaders headers;

}
