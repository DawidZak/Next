package com.next.dzejk.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;

import lombok.Data;
@Data
@Embeddable
@MappedSuperclass
public abstract class Person  {

		protected String Name;
		@Column (name="surename")		
		protected String Surename;
		protected int Age;
		protected String bornDate;
		protected String bornPlace;
		protected String password;
		protected String PESEL;
}
