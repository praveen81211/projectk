package com.fin.ExpenTrack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fin.ExpenTrack.entities.Category;
import com.fin.ExpenTrack.entities.Expenditure;
import com.fin.ExpenTrack.entities.Users;
import com.fin.ExpenTrack.repos.ExpenditureRepo;
import com.fin.ExpenTrack.repos.UsersRepo;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class UserController {

	@Autowired
	UsersRepo usersRepo;

	@GetMapping("/usernamelist")
	@Operation(summary = "list all usernames")
	public List<Users> listofusers() {
		return usersRepo.findAll();
     
	}

	
}