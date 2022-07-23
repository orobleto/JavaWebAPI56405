package com.educacionit.utilidades;

import java.util.Base64;

public final class EsquemaBase64 {
	private EsquemaBase64() {

	}

	public static String getCode(String str) {
		return Base64.getEncoder().encodeToString(str.getBytes());
	}

	public static String getString(String str) {
		return new String(Base64.getDecoder().decode(str));
	}

}
