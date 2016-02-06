/**
 * 
 */
package com.next.dzejk.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data

public class Region {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	private  String regionName;
	
	Region(){};
	public Region(String regionName) {
		this.regionName=regionName;
	}
}
