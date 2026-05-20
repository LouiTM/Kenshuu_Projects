package com.example.ToDoAPI.domain;

public class ToDo {

	private String id;
	private String title;
	private String status;
	private String details;

	public ToDo() {
	}

	public ToDo(String id, String title, String status, String details) {
		this.id = id;
		this.title = title;
		this.status = status;
		this.details = details;
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getStatus() {
		return status;
	}

	public String getDetails() {
		return details;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}
