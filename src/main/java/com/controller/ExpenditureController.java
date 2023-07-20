package com.fin.ExpenTrack.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fin.ExpenTrack.entities.Expenditure;
import com.fin.ExpenTrack.repos.ExpenditureRepo;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class ExpenditureController {

	@Autowired
	ExpenditureRepo expenditureRepo;

//2
	@GetMapping("list/allExp/byCategory/{categorycode}/{username}")
	@Operation(summary = "list expenses by category")
	public List<Expenditure> getAllExpByCat(@PathVariable("categorycode") String categorycode,
			@PathVariable("username") String username) {

		var exp = expenditureRepo.listAllExpByCatAndUsr(username, categorycode,
				PageRequest.of(0, 5, Sort.by("expid").descending()));
		return exp;

	}
//3
	@GetMapping("list/allExp/byPayMode/{payMode}/{username}")
	@Operation(summary = "list all expenses by payment mode")
	public List<Expenditure> getAllExpByPayMode(@PathVariable("payMode") String paymode,
			@PathVariable("username") String username) {

		var exp = expenditureRepo.listAllExpByPayModeAndUsr(username, paymode,
				PageRequest.of(0, 3, Sort.by("expid").descending()));
		return exp;

	}

	// 4
	@GetMapping("list/allExp/btwDates/{username}/{startDate}/{endDate}")
	@Operation(summary = "list expenses of user by given dates")
	public List<Expenditure> getAllExpByPayMode(@PathVariable("username") String username,
			@PathVariable("startDate") Date startDate, @Param("endDate") Date endDate) {

		var exp = expenditureRepo.listAllExpBtwDates(username, startDate, endDate,
				PageRequest.of(0, 3, Sort.by("expid").descending()));
		return exp;
		

	}

	// 5
	@GetMapping("/listallExpbyTags/{tag}")
	@Operation(summary = "list all expenses based on tags")
	public List<Expenditure> getAllExpByPayMode(@PathVariable("tag") String tag) {

		var exp = expenditureRepo.listAllExpByTags(tag);
		return exp;

	}

//6
	@GetMapping("/listallExpCatTamount/{month}")
	@Operation(summary = "list expeses summery for each category in given month")
	public List<String> getAllExpCatAndTamount(@PathVariable("month") int month) {

		var exp = expenditureRepo.listAllExpCatAndTamount(month);
		return exp;

	}

	// 7
	@GetMapping("/topFiveExp/{username}")
	@Operation(summary = "list top five expenses")
	public List<Expenditure> getTopFive(@PathVariable("username") String name) {
		var exp = expenditureRepo.listTopFiveExp(name, PageRequest.of(0, 5, Sort.by("expid").descending()));
		return exp;
	}

	// 8
	@DeleteMapping("deleteExpenditure/{id}")
	@Operation(summary = "allow delete expenditure")
	public void delexp(@PathVariable("id") int id) {
		var exp = expenditureRepo.findById(id);
		if (exp != null) {
			expenditureRepo.deleteById(id);
		}
	}

	// 8
	@PutMapping("updateExpenditure/{amount}/{id}")
	@Operation(summary = "allow update expenditure")
	public void updexp(@PathVariable("amount") double amount, @PathVariable("id") int id) {
		var exp = expenditureRepo.findById(id);
		if (exp.isPresent()) {
			var b = exp.get();
			b.setAmount(amount);
			expenditureRepo.save(b);
		}
	}

	// 12
	@PostMapping("/addnewexp")
	@Operation(summary = "add new expenditure")
	public Expenditure addnewexp(@RequestBody Expenditure exp) {
		expenditureRepo.save(exp);

		return exp;
	}

}