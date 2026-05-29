package com.example.ToDoAPI.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.ToDoAPI.dto.ToDoRequest;
import com.example.ToDoAPI.dto.ToDoResponse;
import com.example.ToDoAPI.entity.ToDo;
import com.example.ToDoAPI.mapper.ToDoMapper;

@RestController
@RequestMapping("/todos")
public class ToDoController {

	@Autowired
	ToDoMapper toDoMapper;

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ToDoResponse findById(@PathVariable int id) {
		ToDo todo = toDoMapper.findById(id);
		ToDoResponse toDoResponse = new ToDoResponse();
		BeanUtils.copyProperties(todo, toDoResponse);
		return toDoResponse;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ToDoResponse> getToDos() {
		List<ToDoResponse> toDoResponseList = new ArrayList<>();
		List<ToDo> toDoList = toDoMapper.findAll();
		toDoList.forEach(todo -> {
			ToDoResponse toDoResponse = new ToDoResponse();
			BeanUtils.copyProperties(todo, toDoResponse);
			toDoResponseList.add(toDoResponse);
		});

		return toDoResponseList;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ToDoResponse doPost(@RequestBody ToDoRequest toDoRequest) {
		ToDo todo = new ToDo();
		BeanUtils.copyProperties(toDoRequest, todo);
		toDoMapper.insert(todo);
		ToDoResponse toDoResponse = new ToDoResponse();
		BeanUtils.copyProperties(todo, toDoResponse);
		return toDoResponse;
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void doDelete(@PathVariable int id) {
		toDoMapper.delete(id);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ToDoResponse doPut(@RequestBody ToDoRequest toDoRequest, @PathVariable int id) {
		ToDo todo = new ToDo();
		BeanUtils.copyProperties(toDoRequest, todo);
		todo.setId(id);
		toDoMapper.update(todo);

		ToDoResponse toDoResponse = new ToDoResponse();
		BeanUtils.copyProperties(todo, toDoResponse);
		return toDoResponse;
	}

	@GetMapping("/filter/{param}/{text}")
	@ResponseStatus(HttpStatus.OK)
	public List<ToDoResponse> filterGet(@PathVariable String param, @PathVariable String text) {

		List<ToDoResponse> toDoResponseList = new ArrayList<>();
		List<ToDo> toDoList = new ArrayList<>();

		toDoList = (param.equals("status") ? toDoMapper.filterByStatus(text) : toDoMapper.filterByTitle(text));

		toDoList.forEach(todo -> {
			ToDoResponse toDoResponse = new ToDoResponse();
			BeanUtils.copyProperties(todo, toDoResponse);
			toDoResponseList.add(toDoResponse);
		});

		return toDoResponseList;

	}

	@PutMapping("/{id}/{status}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> updateStatus(@PathVariable String status, @PathVariable int id) {
		toDoMapper.updateS(status, id);
		if (status.equals("完了")) {
			return ResponseEntity.ok("お疲れ様です！");
		} else if (status.equals("進行中")) {
			return ResponseEntity.ok("あと少し！");
		} else if (status.equals("未着手")) {
			return ResponseEntity.ok("頑張れ！");
		} else {
			return null;
		}
	}

	@GetMapping("/sort/{rule}")
	@ResponseStatus(HttpStatus.OK)
	public List<ToDoResponse> sortGet(@PathVariable String rule) {
		List<ToDoResponse> toDoResponseList = new ArrayList<>();
		List<ToDo> toDoList = new ArrayList<>();
		toDoList = (rule.equals("id") ? toDoMapper.sortById() : toDoMapper.sortByStatus());
		toDoList.forEach(todo -> {
			ToDoResponse toDoResponse = new ToDoResponse();
			BeanUtils.copyProperties(todo, toDoResponse);
			toDoResponseList.add(toDoResponse);
		});
		return toDoResponseList;
	}
}