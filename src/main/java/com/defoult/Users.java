package com.defoult;

// creo la class Users

public class Users {
	private String firstName,lastName,cf,email,password;
	private String role;
	private String message;
	

	public Users() {
		super();
	}

	public Users(String firstName, String lastName, String cf,String email, String password, String role, String message) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.cf = cf;
		this.email = email;
		this.password = password;
		this.role=role;
		this.message=message;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getCf() {
		return cf;
	}
	
	public void setCf(String cf) {
		this.cf = cf;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
