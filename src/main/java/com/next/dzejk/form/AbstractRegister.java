package com.next.dzejk.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public abstract class AbstractRegister {
	protected int ID;
	@NotEmpty
	protected String firstName;
	@Size(min = 3, message = "First name cannot be blank")
	protected String lastName;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
