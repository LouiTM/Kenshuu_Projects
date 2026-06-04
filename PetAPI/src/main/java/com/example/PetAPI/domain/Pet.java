package com.example.PetAPI.domain;

import lombok.Data;

@Data
public class Pet {

	private Integer id;
	private String name;
	private String category;
	private String status;
}