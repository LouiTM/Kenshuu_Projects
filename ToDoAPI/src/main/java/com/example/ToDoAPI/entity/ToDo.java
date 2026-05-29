package com.example.ToDoAPI.entity;

import lombok.Data;

@Data
public class ToDo {

	private Integer id;
	private String title;
	private String status;
	private String detail;

	public String getDetail() {
		return this.detail;
	}
}
