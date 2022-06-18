package com.educacionit.intefaces;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public interface MariaDB {

	default Connection getConexion() {
		Connection connection = null;
		Properties propiedades = new Properties();
		try {
			// Thread.currentThread().getContextClassLoader().getResourceAsStream("database.properties");/
			propiedades.load(new FileInputStream("src/main/resources/database.properties"));
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

	default String getKEY() {
		String key = null;
		Properties propiedades = new Properties();
		try {
			propiedades.load(new FileInputStream("src/main/resources/database.properties"));
			key = propiedades.getProperty("key");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return key;
	}
}
