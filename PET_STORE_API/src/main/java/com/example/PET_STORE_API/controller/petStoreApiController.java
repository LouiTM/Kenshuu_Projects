package com.example.PET_STORE_API.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.PET_STORE_API.domain.Pet;
import com.example.PET_STORE_API.service.petStoreApiService;

@RestController
public class petStoreApiController {

	@Autowired
	private petStoreApiService petService;

	@GetMapping("/pet")
	public List<Pet> showPets() {
		return petService.showPets();
	}

	@PostMapping("/pet")
	public void addPet(@RequestBody Pet pet) {
		petService.addPet(pet);
	}

	@PutMapping("/pet/{petId}")
	public void updatePet(@PathVariable String petId, @RequestBody Pet pet) {
		petService.updatePet(petId, pet);
	}

	@GetMapping("pet/findByStatus/{status}")
	public List<Pet> findPetsByStatus(@PathVariable String status) {
		return petService.findPetsByStatus(status);
	}

	@GetMapping("pet/{petId}")
	public Pet findPetById(@PathVariable String petId) {
		return petService.findPetById(petId);
	}

	@DeleteMapping("pet/{petId}")
	public void deletePet(@PathVariable String petId) {
		petService.deletePet(petId);
	}
}