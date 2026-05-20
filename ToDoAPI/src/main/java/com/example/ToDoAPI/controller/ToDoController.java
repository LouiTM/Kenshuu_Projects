package com.example.ToDoAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ToDoAPI.domain.ToDo;
import com.example.ToDoAPI.service.ToDoService;

@RestController
public class ToDoController {

	@Autowired
	private ToDoService toDoService;

	@GetMapping("/ToDo")
	public List<ToDo> showToDo() {
		return toDoService.showToDo();
	}

	@GetMapping("/ToDo/{id}")
	public ToDo showToDoById(@PathVariable String id) {
		return toDoService.showToDoById(id);
	}

	@PostMapping("/ToDo")
	public void addToDo(@RequestBody ToDo toDo) {
		toDoService.addToDo(toDo);
	}

	@DeleteMapping("/ToDo/{id}")
	public void deleteToDo(@PathVariable String id) {
		toDoService.deleteToDo(id);
	}

	@PutMapping("/ToDo/{id}")
	public void updateToDoById(@RequestBody ToDo toDo, @PathVariable String id) {
		toDoService.updateToDoById(toDo, id);
	}

	@PutMapping("/ToDo/{id}/{status}")
	public void statusUpdate(@PathVariable String id, @PathVariable String status) {
		toDoService.statusUpdate(id, status);
	}

	@GetMapping("/ToDo/sort/{category}")
	public void sortByCategory(@PathVariable String category) {
		toDoService.sortByCategory(category);
	}
}
