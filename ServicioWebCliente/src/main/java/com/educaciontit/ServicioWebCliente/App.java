package com.educaciontit.ServicioWebCliente;

import java.rmi.RemoteException;

import com.educacionit.dtos.UsuarioDTO;
import com.educacionit.servicios.UsuarioServicio;
import com.educacionit.servicios.UsuarioServicioProxy;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		UsuarioDTO usuario = new UsuarioDTO("1234", "octavio@gmail.com", "2022-06-06", "2022-09-13 18:06:03");

		UsuarioServicio usuarioServicio = new UsuarioServicioProxy();
		
		try {
			System.out.println(usuarioServicio.insertarEntidad(usuario));
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}
}
