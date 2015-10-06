package com.next.dzejk.model;

public class PersonModel  {

		protected String Name;
		protected String Surename;
		protected int Age;
		protected String bornDate;
		
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
		@Override
		public String toString() {
			return "PersonModel [Name=" + Name + ", Surename=" + Surename
					+ ", Age=" + Age + ", bornDate=" + bornDate + "]";
		}
		
		
		
}
