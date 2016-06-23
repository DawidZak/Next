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
@Data

public class Region {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="regionId")
	//private User user;
	private int Id;
	private  String regionName;
	//@OneToMany//(mappedBy="User")
	//private Set<User> users;
	Region(){};
	public Region(String regionName) {
		this.regionName=regionName;
	}
}
