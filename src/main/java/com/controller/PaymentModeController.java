package com.fin.ExpenTrack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fin.ExpenTrack.entities.PaymentMode;
import com.fin.ExpenTrack.repos.PaymentModeRepo;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class PaymentModeController {

	@Autowired
	PaymentModeRepo paymentModeRepo;

//1
	@PostMapping("/add/new/paymentMode")
	@Operation(summary = "add new paymentmode for a user with required details")
	public PaymentMode addNewPaymentMode(@RequestBody PaymentMode pm) {
		paymentModeRepo.save(pm);
		return pm;
	}

	@GetMapping("/list/paymentModes/{username}")
	@Operation(summary = "list payment mode of current user")
	public List<String> getlistpay(@PathVariable("username") String username) {
		return paymentModeRepo.listPayModesOfUser(username);
	}

//9
	@DeleteMapping("/delete/paymentMode/{code}")
	@Operation(summary = "delete payment mode of current user")
	public void delpay(@PathVariable("code") String code) {
		var a = paymentModeRepo.findById(code);
		if (a != null) {

			paymentModeRepo.deleteById(code);

		}
	}
//13	
	@GetMapping("/list/paymentmode/{remarks}")
	@Operation(summary = "list payname by remarks")
	public List<String> getusername(@PathVariable("remarks") String remarks) {
		return paymentModeRepo.listusername(remarks);
	}

//9
	@PutMapping("/updpaymentmode/{code}/{username}/{name}")
	@Operation(summary = "update payment of current user ")
	public void updpay(@PathVariable("code") String code, @PathVariable("username") String username,
			@PathVariable("name") String name)

	{
		var a = paymentModeRepo.findById(code);
		if (a.isPresent()) {
			var b = a.get();
			if (b.getPaymentuser().getUser_name().equals(username)) {
				b.setPaymentType(name);
				paymentModeRepo.save(b);
			}
		}

	}
}