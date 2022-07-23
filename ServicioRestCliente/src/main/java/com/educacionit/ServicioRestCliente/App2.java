package com.educacionit.ServicioRestCliente;

import java.net.URI;

import com.educacionit.dtos.UsuarioDTO;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriBuilder;

public class App2 {
	public static void main(String[] args) {
		// URL Padre
		final URI URL = UriBuilder.fromUri("http://localhost:8080/ServicioRest/apis").build();
		// configuraciones adicionales DELETE PUD etc
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.property(ClientProperties.SUPPRESS_HTTP_COMPLIANCE_VALIDATION, true);
		// encargar de conectar
		Client cliente = ClientBuilder.newClient(clientConfig);

		// acceso a los recursos
		WebTarget targetUsuarios = cliente.target(URL).path("usuarios").path("buscar");
		Invocation.Builder builder = targetUsuarios.path("user12@educacionit.com").request(MediaType.APPLICATION_JSON);
		
		UsuarioDTO usuarioDTO = builder.get(UsuarioDTO.class);
		System.out.println(usuarioDTO);
		
	}

}
