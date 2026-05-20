package com.example.ToDoAPI.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ToDoAPI.domain.ToDo;

@Service
public class ToDoService {

	List<ToDo> toDos = new ArrayList<>(Arrays.asList(new ToDo("1", "宿題", "未着手", "科学と数学"),
			new ToDo("2", "部屋の掃除", "進行中", "リビングの掃除機がけと換気"), new ToDo("3", "食材の買い出し", "未着手", "今晩のカレーの材料（玉ねぎ、人参、牛肉）"),
			new ToDo("4", "APIの動作確認", "未着手", "DELETEメソッドの異常系（存在しないID）テスト"),
			new ToDo("5", "読書（技術書）", "完了", "Spring Boot公式ドキュメントのDIコンテナの章")));

	public List<ToDo> showToDo() {
		return toDos;
	}

	public ToDo showToDoById(String id) {
		for (ToDo todo : toDos) {
			if (todo.getId().equals(id)) {
				return todo;
			}
		}
		return null;
	}

	public void addToDo(ToDo todo) {
		toDos.add(todo);
	}

	public void deleteToDo(String id) {
		toDos.removeIf(todo -> todo.getId().equals(id));
	}

	public void updateToDoById(ToDo todo, String id) {
		for (ToDo toDo : toDos) {
			if (toDo.getId().equals(id)) {
				toDos.set(toDos.indexOf(toDo), todo);
			}
		}
	}

	public void statusUpdate(String id, String status) {
		for (ToDo toDo : toDos) {
			if (toDo.getId().equals(id)) {
				toDo.setStatus(status);
			}
		}
	}

	public void sortByCategory(String category) {
		if (category.equals("id")) {
			toDos.sort(Comparator.comparing(ToDo::getId));
		} else if (category.equals("status")) {
			List<String> statusOrder = List.of("完了", "進行中", "未着手");
			toDos.sort(Comparator.comparing(todo -> statusOrder.indexOf(todo.getStatus())));
		}
	}

}
