package com.educacionit.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.octaviorobleto.commons.utilities.text.CodeUtils;

public class UsuarioDTO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
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
		return "UsuarioDTO [correo=" + correo + ", clave=[" + clave + " - " + CodeUtils.BASE64_Decode(clave)
				+ "], fechaCreacion=" + fechaCreacion + ", fechaModificacion=" + fechaModificacion + ", mensaje="
				+ mensaje + "]";
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getClave() {
		return clave;
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
