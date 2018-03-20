package br.usjt.arqsw.entity;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * 
 * @author Lucas Nagaoka | RA: 81513916
 *
 */

public class Usuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;

	@NotNull
	private String username;

	@NotNull
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
