package com.example.ToDoAPI.dto;

import lombok.Data;

@Data
public class ToDoRequest {

	private String title;
	private String status;
	private String detail;
}
