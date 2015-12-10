package com.next.dzejk.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
@Data
public class RegisterUser {
	
	private String firstName;
	
	protected String lastName;
	
	protected String bornDate;
	protected String password;

	protected String PESEL;
	
	protected String email;

	protected String city;
	protected int IdR;
	protected int IdD;
}
