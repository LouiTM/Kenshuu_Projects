package com.example.ToDoAPI.dto;

import lombok.Data;

@Data
public class ToDoResponse {

	private Integer id;
	private String title;
	private String status;
	private String detail;
}
