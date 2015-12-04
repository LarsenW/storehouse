package com.storehouse.web.utils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


public class FileValidator implements Validator {


	@Override
	public boolean supports(Class<?> paramClass) {
		return File.class.equals(paramClass);

	}

	@Override
	public void validate(Object target, Errors errors) {
		File file = (File) target;
		if (file.getFile().getSize() == 0) {
			errors.reject("please select a file");
		}
	}

}
