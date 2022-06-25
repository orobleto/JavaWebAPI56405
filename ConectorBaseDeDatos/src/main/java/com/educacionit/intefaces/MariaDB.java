package com.educacionit.intefaces;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public interface MariaDB {

	InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("database.properties");

	Properties propiedades = new Properties();

	default Connection getConexion() {
		Connection connection = null;

		try {

			propiedades.load(inputStream);
			String driver = propiedades.getProperty("driver");
			String url = propiedades.getProperty("url");
			String usuario = propiedades.getProperty("usuario");
			String clave = propiedades.getProperty("clave");

			Class.forName(driver);
			connection = DriverManager.getConnection(url, usuario, clave);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}

	//
	default String getKEY() {
		String key = null;

		try {
			propiedades.load(inputStream);
			key = propiedades.getProperty("key");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return key;
	}
}
