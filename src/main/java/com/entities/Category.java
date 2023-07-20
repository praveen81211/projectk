package com.fin.ExpenTrack.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "CATEGORY")
public class Category {

	@Id
	@Column(name = "category_code")
	private String category_code;

	@Column(name = "category_name")
	private String cname;

	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Expenditure> catexp = new ArrayList<Expenditure>();

	public String getCatCode() {
		return category_code;
	}

	public void setCatCode(String category_code) {
		this.category_code = category_code;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public List<Expenditure> getCatexp() {
		return catexp;
	}

	public void setCatexp(List<Expenditure> catexp) {
		this.catexp = catexp;
	}

}