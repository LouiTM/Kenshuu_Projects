package com.example.PetAPI.dto;

import lombok.Data;

@Data
public class petResponse {

	private Integer id;
	private String name;
	private String category;
	private String status;
}
