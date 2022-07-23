package com.educacionit.servicios;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
//http://localhost:8080/ServicioRest/apis/MiPrimerApp/inicio
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path(value = "/MiPrimerApp")
public class MiPrimerServicio {

	// String con el recurso donde redirige

	@GET
	@Path("/inicio")
	@Produces(MediaType.TEXT_HTML)
	public String inicio() {
		return "<h1>Hola Mundo</h1>";
	}

	// patron builder
	@GET
	@Path("/respuesta")
	@Produces(MediaType.TEXT_HTML)
	public Response respuesta() {
		return Response.status(Status.ACCEPTED).entity("<h1>Recurso aceptado...</h1>").build();
	}

}
