package com.next.dzejk.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;
@Data
public abstract class AbstractRegister {
	@NotEmpty
	protected String firstName;
	@Size(min=3, message = "First name cannot be blank")
	protected String lastName;
}
