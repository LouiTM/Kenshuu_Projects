package com.example.PetAPI.dto;

import lombok.Data;

@Data
public class petRequest {

	private String name;
	private String category;
	private String status;
}
