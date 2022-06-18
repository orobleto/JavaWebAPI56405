package com.educacionit.ConectorBaseDeDatos;

import java.time.LocalDateTime;

import com.educacionit.entidades.Usuario;
import com.educacionit.implementaciones.mariaDB.UsuarioImplementacion;
import com.educacionit.utilidades.Fechas;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

			
		UsuarioImplementacion usuarioImplementacion = new UsuarioImplementacion();
		usuarioImplementacion.insertar(new Usuario("user1@educacionit.com", "user1.1234", Fechas.getLocalDate("1982-06-18"),
				LocalDateTime.now()));
		usuarioImplementacion.insertar(new Usuario("user2@educacionit.com", "user2.1234", Fechas.getLocalDate("1983-03-18"),
				LocalDateTime.now()));
		usuarioImplementacion.insertar(new Usuario("user3@educacionit.com", "user3.1234", Fechas.getLocalDate("2000-07-21"),
				LocalDateTime.now()));
		usuarioImplementacion.insertar(new Usuario("user4@educacionit.com", "user4.1234", Fechas.getLocalDate("1999-06-18"),
				LocalDateTime.now()));
		


	}
}
