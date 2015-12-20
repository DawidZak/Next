package com.next.dzejk.form;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.next.dzejk.model.User;

import lombok.Data;
@Data

public class RegisterUser {
	@NotNull
	private String firstName;
	@Size(min=2)
	protected String lastName;

	protected String password;

	protected String PESEL;
	
	protected String email;

	protected String city;
	@NotNull
	protected int IdR;
	protected int IdD;
}
