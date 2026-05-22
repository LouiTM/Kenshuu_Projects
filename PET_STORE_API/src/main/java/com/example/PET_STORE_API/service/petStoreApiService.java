package com.example.PET_STORE_API.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.PET_STORE_API.domain.Pet;

@Service
public class petStoreApiService {

	List<Pet> pets = new ArrayList<>(Arrays.asList(new Pet("1", "poppy", "doberman", "available"),
			new Pet("2", "charlie", "poodle", "available"), new Pet("3", "luna", "persian", "pending"),
			new Pet("4", "max", "bulldog", "sold"), new Pet("5", "coco", "shiba", "available")));

	// private static final List<String> STATUS_ORDER = List.of("");

	public List<Pet> showPets() {
		return pets;
	}

	public void addPet(Pet pet) {
		pets.add(pet);
	}

	public void updatePet(String petId, Pet pet) {
		pets.stream().filter(pt -> pt.getPetId().equals(petId)).findFirst()
				.ifPresentOrElse(pt -> pets.set(pets.indexOf(pt), pet), null);
	}

	public List<Pet> findPetsByStatus(String status) {
		return pets.stream().filter(pt -> pt.getPetStatus().equals(status)).toList();
	}

	public Pet findPetById(String petId) {
		return pets.stream().filter(pt -> pt.getPetId().equals(petId)).findFirst().orElse(null);
	}

	public void deletePet(String petId) {
		pets.stream().filter(pt -> pt.getPetId().equals(petId)).findFirst()
				.ifPresentOrElse(pt -> pets.remove(pets.indexOf(pt)), null);
	}
}
