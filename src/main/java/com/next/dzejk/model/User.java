package com.next.dzejk.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.stereotype.Component;

import lombok.Data;
@Data
@Component
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
		public User(){};
		public User(String firstName, String lastName, String password, String pESEL, String email,
				String city, int idR, int idD) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
	
			this.password = password;
			PESEL = pESEL;
			this.email = email;
			this.city = city;
			IdR = idR;
			IdD = idD;
		};
		
		
}
 