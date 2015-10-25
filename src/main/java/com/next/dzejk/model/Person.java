package com.next.dzejk.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person  {

		protected String Name;
		@Column (name="surename")
		
		protected String Surename;
		protected int Age;
		protected String bornDate;
		protected String bornPlace;
		
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public String getSurename() {
			return Surename;
		}
		public void setSurename(String surename) {
			Surename = surename;
		}
		public int getAge() {
			return Age;
		}
		public void setAge(int age) {
			Age = age;
		}
		public String getBornDate() {
			return bornDate;
		}
		public void setBornDate(String bornDate) {
			this.bornDate = bornDate;
		}
		public String getBornPlace() {
			return bornPlace;
		}
		public void setBornPlace(String bornPlace) {
			this.bornPlace = bornPlace;
		}
		@Override
		public String toString() {
			return "PersonModel [Name=" + Name + ", Surename=" + Surename
					+ ", Age=" + Age + ", bornDate=" + bornDate + "]";
		}
		
		
		
}
