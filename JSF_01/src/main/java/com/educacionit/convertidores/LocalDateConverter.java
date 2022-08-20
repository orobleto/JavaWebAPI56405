package com.educacionit.convertidores;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "com.educacionit.convertidores.LocalDateConverter")
public class LocalDateConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null) {
			return null;
		}

		return LocalDate.parse(value, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
			return null;
		}

		LocalDate localDate = null;
		if (value instanceof LocalDate) {
			localDate = (LocalDate) value;
			return localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		}

		return "";
	}

}
