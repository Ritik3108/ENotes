package com.User;

public class UserDetails {
	
	private String firstname,email,password;
	private int id;
	
	

	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDetails(String firstname, String email, String password) {
		super();
		this.firstname = firstname;
		this.email = email;
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
