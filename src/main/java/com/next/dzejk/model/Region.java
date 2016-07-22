/**
 * 
 */
package com.next.dzejk.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity


public class Region {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="regionId")
	//private User user;
	private int Id;
	private  String regionName;
	//@OneToMany//(mappedBy="User")
	//private Set<User> users;
	public Region(){};
	public Region(String regionName) {
		this.regionName=regionName;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
}
