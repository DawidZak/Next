package com.next.dzejk.form;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.next.dzejk.model.User;

import lombok.Data;
@Data

public class RegisterUser extends AbstractRegister {
	@NotEmpty
	protected String password;
	@NotEmpty @Digits(integer=3, fraction = 0)
	protected String PESEL;
	@NotEmpty @Email
	protected String email;
	@NotEmpty
	protected String city;
	protected int IdR;
	protected int IdD;
}
