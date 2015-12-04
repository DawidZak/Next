package com.next.dzejk.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;
@Data
@Entity
public  class User  {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int ID;
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
 