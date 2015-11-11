package com.next.dzejk.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;

import lombok.Data;
@Data
@Embeddable
@MappedSuperclass
public abstract class Person  {

		protected String firstName;		
		protected String lastName;
		protected String bornDate;
		protected String password;
		protected String PESEL;
		protected String email;
		protected String city;
		protected int IdR;
		protected int IdD;
}
