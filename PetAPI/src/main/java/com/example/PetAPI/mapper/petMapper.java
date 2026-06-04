package com.example.PetAPI.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.PetAPI.domain.Pet;

@Mapper
public interface petMapper {

	Pet findById(int id);

	List<Pet> findAll();

	int insert(@Param("pet") Pet pet);

	int update(@Param("pet") Pet pet);

	int updateS(String status, int id);

	boolean delete(int id);

	List<Pet> filterByStatus(String status);

	List<Pet> filterByTitle(String name);

	List<Pet> sortById();

	List<Pet> sortByStatus();

}
