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
@RequiredArgsConstructor
public class Role {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	private final String name;

}
