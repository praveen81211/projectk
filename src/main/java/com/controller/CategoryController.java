package com.fin.ExpenTrack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fin.ExpenTrack.entities.Category;
import com.fin.ExpenTrack.repos.CategoryRepo;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class CategoryController {

	@Autowired
	CategoryRepo categoryRepo;

	// 13
	@GetMapping("/CategoryList")
	@Operation(summary = "list all the available categories")
	public List<Category> listofcat() {
		return categoryRepo.findAll();

	}
}
