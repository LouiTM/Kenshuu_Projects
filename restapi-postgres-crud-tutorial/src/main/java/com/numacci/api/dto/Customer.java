package com.numacci.api.dto;

import jakarta.validation.constraints.NotNull;

public class Customer {
	@NotNull
	private String id;

	@NotNull
	private String username;

	@NotNull
	private String email;

	@NotNull
	private String phoneNumber;

	@NotNull
	private String postCode;

	public String getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
}