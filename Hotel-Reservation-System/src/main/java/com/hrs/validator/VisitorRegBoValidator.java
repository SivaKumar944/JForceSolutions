package com.hrs.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.hrs.bo.VisitorRegBo;

@Component
public class VisitorRegBoValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		  return clazz.isAssignableFrom(VisitorRegBo.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		VisitorRegBo bo=(VisitorRegBo) target;
		if(isEmpty(bo.getVisitorName())) {
			errors.rejectValue("visitorName", "visitorName.blank");
		}
		if(isEmpty(bo.getPassword())) {
			errors.rejectValue("password", "password.blank");
		}
		if(isEmpty(bo.getEmailAddress())) {
			errors.rejectValue("emailAddress", "emailAddress.blank");
		}
		if(isEmpty(bo.getMobileNumber())) {
			errors.rejectValue("mobileNumber", "mobileNumber.blank");
		}
		
	}
	private boolean  isEmpty(String s) {
		if(s==null||s.trim().length()==0) {
			return true;
		}
		return false;
	}
	

}
