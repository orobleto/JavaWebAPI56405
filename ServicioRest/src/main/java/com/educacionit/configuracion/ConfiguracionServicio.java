package com.educacionit.configuracion;

import org.glassfish.jersey.server.ResourceConfig;

import jakarta.ws.rs.ApplicationPath;

@ApplicationPath(value = "/apis")
public class ConfiguracionServicio extends ResourceConfig {
	public ConfiguracionServicio() {
		packages("com.educacionit");
	}
}
