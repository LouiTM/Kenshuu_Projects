package com.example.PetAPI.controller;

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

import com.example.PetAPI.domain.Pet;
import com.example.PetAPI.dto.petRequest;
import com.example.PetAPI.dto.petResponse;
import com.example.PetAPI.mapper.petMapper;

@RestController
@RequestMapping("/pets")
public class petController {

	@Autowired
	petMapper petmapper;

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public petResponse findById(@PathVariable int id) {
		Pet pet = petmapper.findById(id);
		petResponse petresponse = new petResponse();
		BeanUtils.copyProperties(pet, petresponse);
		return petresponse;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<petResponse> getToDos() {
		List<petResponse> petresponseList = new ArrayList<>();
		List<Pet> petList = petmapper.findAll();
		petList.forEach(pet -> {
			petResponse petresponse = new petResponse();
			BeanUtils.copyProperties(pet, petresponse);
			petresponseList.add(petresponse);
		});

		return petresponseList;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public petResponse doPost(@RequestBody petRequest petrequest) {
		Pet pet = new Pet();
		BeanUtils.copyProperties(petrequest, pet);
		petmapper.insert(pet);
		petResponse petresponse = new petResponse();
		BeanUtils.copyProperties(pet, petresponse);
		return petresponse;
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void doDelete(@PathVariable int id) {
		petmapper.delete(id);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public petResponse doPut(@RequestBody petRequest petrequest, @PathVariable int id) {
		Pet pet = new Pet();
		BeanUtils.copyProperties(petrequest, pet);
		pet.setId(id);
		petmapper.update(pet);
		petResponse petresponse = new petResponse();
		BeanUtils.copyProperties(pet, petresponse);
		return petresponse;
	}

	@GetMapping("/filter/{status}")
	@ResponseStatus(HttpStatus.OK)
	public List<petResponse> filterGet(@PathVariable String status) {

		List<petResponse> petresponseList = new ArrayList<>();
		List<Pet> petList = petmapper.filterByStatus(status);
		petList.forEach(pet -> {
			petResponse petresponse = new petResponse();
			BeanUtils.copyProperties(pet, petresponse);
			petresponseList.add(petresponse);
		});

		return petresponseList;

	}

	@PutMapping("/{id}/{status}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> updateStatus(@PathVariable String status, @PathVariable int id) {
		petmapper.updateS(status, id);
		if (status.equals("available")) {
			return ResponseEntity.ok("在庫あり");
		} else if (status.equals("pending")) {
			return ResponseEntity.ok("入荷待ち");
		} else if (status.equals("sold")) {
			return ResponseEntity.ok("売り切れ");
		} else {
			return null;
		}
	}

	@GetMapping("/sort/{rule}")
	@ResponseStatus(HttpStatus.OK)
	public List<petResponse> sortGet(@PathVariable String rule) {
		List<petResponse> petresponseList = new ArrayList<>();
		List<Pet> petList = new ArrayList<>();
		petList = (rule.equals("id") ? petmapper.sortById() : petmapper.sortByStatus());
		petList.forEach(pet -> {
			petResponse petresponse = new petResponse();
			BeanUtils.copyProperties(pet, petresponse);
			petresponseList.add(petresponse);
		});
		return petresponseList;
	}
}