package com.educacionit.validadores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator
public class CorreoValidador implements Validator {

	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String correo = value.toString();

		boolean esCorreo = correo.matches("([a-zA-Z0-9]+(\\.?[a-zA-Z0-9])*)+@(([a-zA-Z]+)\\.([a-zA-Z]+))");
		boolean esDominioCorrecto = correo.endsWith("educacionit.com");

		if (!esCorreo) {
			throw new ValidatorException(new FacesMessage("No es un correo electronico valido"));
		}

		if (!esDominioCorrecto) {
			throw new ValidatorException(new FacesMessage("Debe ser del dominio de Educacion IT"));
		}

	}

}
