package com.example.PET_STORE_API.domain;

public class Pet {

	private String petId;
	private String petName;
	private String petCategory;
	private String petStatus;

	public Pet() {
	}

	public Pet(String petId, String petName, String petCategory, String petStatus) {
		this.petId = petId;
		this.petName = petName;
		this.petCategory = petCategory;
		this.petStatus = petStatus;
	}

	public String getPetId() {
		return petId;
	}

	public String getPetName() {
		return petName;
	}

	public String getPetCategory() {
		return petCategory;
	}

	public String getPetStatus() {
		return petStatus;
	}

	public void setPetId(String petId) {
		this.petId = petId;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public void setPetCategory(String petCategory) {
		this.petCategory = petCategory;
	}

	public void setPetStatus(String petStatus) {
		this.petStatus = petStatus;
	}
}
