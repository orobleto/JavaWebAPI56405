package com.educacionit.ServicioRestCliente;

import java.net.URI;
import java.util.Iterator;
import java.util.List;

import com.educacionit.dtos.UsuarioDTO;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		// URL Padre
		final URI URL = UriBuilder.fromUri("http://localhost:8080/ServicioRest/apis").build();
		// configuraciones adicionales DELETE PUD etc
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.property(ClientProperties.SUPPRESS_HTTP_COMPLIANCE_VALIDATION, true);
		// encargar de conectar
		Client cliente = ClientBuilder.newClient(clientConfig);

		// acceso a los recursos
		WebTarget targetUsuarios = cliente.target(URL).path("usuarios");

		// resolver buscar
		UsuarioDTO usuarioDTO = null;
		try {
			usuarioDTO = buscar("user111111@gmail.com", targetUsuarios);
			System.out.println(usuarioDTO);
		} catch (java.lang.RuntimeException e) {
			e.printStackTrace();
		}

		UsuarioDTO usuarioDTO2 = new UsuarioDTO();
		usuarioDTO2.setCorreo("user111111@gmail.com");
		usuarioDTO2.setClave("User1112.1");
		System.out.println(agregar(usuarioDTO2, targetUsuarios));

		System.out.println("**************arrayUsuarios********************");

		for (UsuarioDTO usDto : arrayUsuarios(targetUsuarios)) {
			System.out.println(usDto);
		}

		System.out.println("***************listUsuarios*******************");
		List<UsuarioDTO> usuarioDTOs = listUsuarios(targetUsuarios);

		System.out.println(usuarioDTOs);

		for (int i = 0; i < usuarioDTOs.size(); i++) {
			System.out.println("-->" + usuarioDTOs.get(i));
		}
		
		System.out.println("***************listUsuarios 2*******************");
		List<UsuarioDTO> listaUsuarios2 = List.of(arrayUsuarios(targetUsuarios));
		
		for (UsuarioDTO user : listaUsuarios2) {
			System.out.println(user);
		}

		System.out.println("Eliminar");
		System.out.println(borrar(usuarioDTO2, targetUsuarios));

	}
	//

	public static UsuarioDTO buscar(String correo, WebTarget target) {
		Response response = target.path("buscar").path(correo).request(MediaType.APPLICATION_JSON).get();
		if (response.getStatus() == 204) {
			throw new RuntimeException("Error no hay contenido....");
		}
		return response.readEntity(UsuarioDTO.class);
	}

	public static boolean agregar(UsuarioDTO usuarioDTO, WebTarget target) {

		Response response = target.path("guardarConCabecera").request(MediaType.APPLICATION_JSON)
				.header("USER-ID", "orobletot").post(Entity.entity(usuarioDTO, MediaType.APPLICATION_JSON));

		if (response.getStatus() == 201) {
			return true;
		}
		return false;
	}

	public static List<UsuarioDTO> listUsuarios(WebTarget target) {
		Response response = target.path("listar").request(MediaType.APPLICATION_JSON).get();
		if (response.getStatus() == 200) {
			return response.readEntity(List.class);
		}
		throw new RuntimeException("Error no hay elementos");
	}

	public static UsuarioDTO[] arrayUsuarios(WebTarget target) {
		Response response = target.path("listar").request(MediaType.APPLICATION_JSON).get();
		if (response.getStatus() == 200) {
			return response.readEntity(UsuarioDTO[].class);
		}
		throw new RuntimeException("Error no hay elementos");
	}

	public static boolean borrar(UsuarioDTO usuarioDTO, WebTarget target) {
		Response response = target.path("eliminar").request(MediaType.APPLICATION_JSON).method("DELETE",
				Entity.entity(usuarioDTO, MediaType.APPLICATION_JSON));
		System.out.println(response.getEntity());
		if (response.getStatus() == 200) {
			return true;
		}
		throw new RuntimeException("Error no hay elementos");
	}

}
