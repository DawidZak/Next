/**
 * 
 */
package com.next.dzejk.model;

import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * @author Dawid
 *
 */
@Entity
public class Role {
	@Id
	private int Id;
	private String Role;

}
