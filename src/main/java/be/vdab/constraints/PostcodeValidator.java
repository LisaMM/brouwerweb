package be.vdab.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PostcodeValidator implements ConstraintValidator<Postcode, Integer> {

	@Override
	public void initialize(Postcode arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(Integer arg0, ConstraintValidatorContext arg1) {
		// TODO Auto-generated method stub
		return false;
	}

}
