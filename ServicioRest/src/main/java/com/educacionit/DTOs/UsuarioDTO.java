package com.educacionit.DTOs;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.educacionit.utilidades.EsquemaBase64;
import com.fasterxml.jackson.annotation.JsonFormat;

public class UsuarioDTO {
	private String correo;
	private String clave;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate fechaCreacion;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime fechaModificacion;

	private String mensaje;

	public UsuarioDTO() {
		super();
	}

	public UsuarioDTO(String correo, String clave, LocalDate fechaCreacion, LocalDateTime fechaModificacion,
			String mensaje) {
		super();
		this.correo = correo;
		this.clave = clave;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		return "UsuarioDTO [correo=" + correo + ", clave=" + getClave() + ", fechaCreacion=" + fechaCreacion
				+ ", fechaModificacion=" + fechaModificacion + ", mensaje=" + mensaje + "]";
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getClave() {
		if (clave == null) {
			return null;
		}
		return EsquemaBase64.getCode(clave);
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDateTime getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(LocalDateTime fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
