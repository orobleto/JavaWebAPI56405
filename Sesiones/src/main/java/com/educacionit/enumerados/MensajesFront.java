package com.educacionit.enumerados;

public enum MensajesFront {
	CREDENCIALES_CORRECTAS("Bienvenido, tus credenciales han sido verificadas"),
	CREDENCIALES_INCORRECTAS("Credenciales Incorrectas, vuelva a intentarlo"),
	CERRAR_SESION("Ha cerrado correctamente la sesion");

	private String mensaje;

	private MensajesFront(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}
}
