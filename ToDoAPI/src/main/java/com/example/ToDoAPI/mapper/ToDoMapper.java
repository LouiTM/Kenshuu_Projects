package com.example.ToDoAPI.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.ToDoAPI.entity.ToDo;

@Mapper
public interface ToDoMapper {

	ToDo findById(int id);

	List<ToDo> findAll();

	int insert(@Param("todo") ToDo todo);

	int update(@Param("todo") ToDo todo);

	boolean delete(int id);

	List<ToDo> filterByStatus(String status);

	List<ToDo> filterByTitle(String title);
}
