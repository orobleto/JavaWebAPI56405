package com.educacionit.principal;

import javax.xml.ws.Endpoint;

import com.educacionit.servicios.MiPrimerServicioWeb;

public class App {
	public static void main(String[] args) {
		System.out.println("Incio");
		Endpoint.publish("http://localhost:8089/ServicioWeb/MiPrimerServicioWeb", new MiPrimerServicioWeb());
		System.out.println("Fin");
	}
}
