/**
 * 
 */
package com.next.dzejk.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor


public class Region {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	private final  String regionName;
 
	

}
