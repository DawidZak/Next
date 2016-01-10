package com.next.dzejk.form;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.next.dzejk.model.User;

import lombok.Data;
@Data

public class RegisterUser {
	@NotEmpty
	private String firstName;
	@Size(min=2, message = "First name cannot be blank")
	protected String lastName;
	@NotEmpty
	protected String password;
	@NotEmpty
	protected String PESEL;
	@NotEmpty
	protected String email;
	@NotEmpty
	protected String city;
	protected int IdR;
	protected int IdD;
}
