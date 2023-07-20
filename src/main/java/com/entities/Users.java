package com.fin.ExpenTrack.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class Users {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;

	@Id
	@Column(name = "user_name")
	private String user_name;

	@Column(name = "user_password")
	private String password;

	@OneToMany(mappedBy = "expuser")
	@JsonIgnore
	private List<Expenditure> userExp = new ArrayList<Expenditure>();

	@OneToMany(mappedBy = "paymentuser", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<PaymentMode> paymentmodes = new ArrayList<PaymentMode>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Expenditure> getUserExp() {
		return userExp;
	}

	public void setUserExp(List<Expenditure> userExp) {
		this.userExp = userExp;
	}

	public List<PaymentMode> getPaymentmodes() {
		return paymentmodes;
	}

	public void setPaymentmodes(List<PaymentMode> paymentmodes) {
		this.paymentmodes = paymentmodes;
	}

}