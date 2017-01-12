package com.next.dzejk.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component

@Entity
//@Scope("session")

//@Table(name ="User")
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
		protected String description;
		@ManyToOne
		protected Region region;
		public User(){};
		public User(String firstName, String lastName, String password, String pESEL, String email,
				String city, int idR) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
	
			this.password = password;
			PESEL = pESEL;
			this.email = email;
			this.city = city;
			IdR = idR;
			
		}
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
		public String getBornDate() {
			return bornDate;
		}
		public void setBornDate(String bornDate) {
			this.bornDate = bornDate;
		}
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
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Region getRegion() {
			return region;
		}
		public void setRegion(Region region) {
			this.region = region;
		}
		
		
}
 