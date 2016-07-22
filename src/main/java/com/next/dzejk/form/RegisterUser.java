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


public class RegisterUser extends AbstractRegister {
	@NotEmpty
	protected String password;
	@NotEmpty @Digits(integer=10, fraction = 0) //Walidacja dziala
	protected String PESEL;
	@NotEmpty @Email
	protected String email;
	@NotEmpty
	protected String city;
	protected int IdR;
	protected int IdD;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPESEL() {
		return PESEL;
	}
	public void setPESEL(String pESEL) {
		PESEL = pESEL;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getIdR() {
		return IdR;
	}
	public void setIdR(int idR) {
		IdR = idR;
	}
	public int getIdD() {
		return IdD;
	}
	public void setIdD(int idD) {
		IdD = idD;
	}
}
