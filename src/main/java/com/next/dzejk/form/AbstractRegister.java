package com.next.dzejk.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public abstract class AbstractRegister {
	@NotEmpty
	private String firstName;
	@Size(min=3, message = "First name cannot be blank")
	protected String lastName;
}
