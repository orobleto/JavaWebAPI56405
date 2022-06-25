package com.educacionit.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.educacionit.entidades.Usuario;
import com.educacionit.enumerados.MensajesFront;
import com.educacionit.implementaciones.mariaDB.UsuarioImplementacion;

/**
 * Servlet implementation class Validaciones
 */
public class Validaciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioImplementacion usuarioImplementacion = new UsuarioImplementacion();

	/**
	 * Default constructor.
	 */
	public Validaciones() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Boolean cerrarSession = Boolean.valueOf(request.getParameter("cerrarSesion"));

		// cerrar sesion
		if (cerrarSession && null != request.getSession().getId()) {
			request.getSession().invalidate();

			request.setAttribute("mensaje", MensajesFront.CERRAR_SESION);
			request.getRequestDispatcher("index.jsp").forward(request, response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String correo = request.getParameter("correo");
		String clave = request.getParameter("clave");
		HttpSession sesion = null;
		Usuario usuario = usuarioImplementacion.buscarPorId(correo);
		String redireccion = "index.jsp";

		request.setAttribute("mensaje", MensajesFront.CREDENCIALES_INCORRECTAS);

		if (null != usuario && usuario.getClave().equals(clave)) {
			sesion = request.getSession();
			sesion.setAttribute("usuario", usuario);
			redireccion = "bienvenido.jsp";
			request.setAttribute("mensaje", MensajesFront.CREDENCIALES_CORRECTAS);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(redireccion);
		dispatcher.forward(request, response);

	}

}
