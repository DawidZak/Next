/**
 * 
 */
package com.next.dzejk.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.RequiredArgsConstructor;


/**
 * @author Dawid
 *
 */
@Entity

public class Role {
	
	public Role(String name) {
		super();
		this.name = name;
	}
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	private  String name;

}
 