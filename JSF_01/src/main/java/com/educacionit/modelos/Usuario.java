package com.educacionit.modelos;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import lombok.Data;

@Data
@ManagedBean
@SessionScoped
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	private String correo;
	private String clave;
	private LocalDate fechaCreacion;
	private LocalDateTime fechaModificacion;

}
