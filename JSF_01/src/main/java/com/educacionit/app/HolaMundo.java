package com.educacionit.app;

import javax.faces.bean.ManagedBean;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// POJO
@ManagedBean(name = "helloWord")
public class HolaMundo {
	private String mensaje;
	private static Logger logger = LogManager.getLogger();

	public HolaMundo() {
		super();
		logger.info("Se ha construido el Hola Mundo");
	}

	@Override
	public String toString() {
		return "HolaMundo [mensaje=" + mensaje + "]";
	}

	// getter
	public String getMensaje() {
		return mensaje;
	}

	// setter
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String welcomefile() {
		return "pagina3";
	}

}
