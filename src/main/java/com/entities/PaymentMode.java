package com.fin.ExpenTrack.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "paymentmode")
public class PaymentMode {

	@Id
	@Column(name = "pay_code")
	private String pay_code;

	@Column(name = "user_name")
	private String user_name;

	@Column(name = "pay_name")
	private String paymentType;

	@Column(name = "remarks")
	private String remarks;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "user_name", insertable = false, updatable = false)
	private Users paymentuser;

	@OneToMany(mappedBy = "paymentMode", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Expenditure> expenditures = new ArrayList<Expenditure>();

	public String getPay_code() {
		return pay_code;
	}

	public void setPay_code(String pay_code) {
		this.pay_code = pay_code;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Users getPaymentuser() {
		return paymentuser;
	}

	public void setPaymentuser(Users paymentuser) {
		this.paymentuser = paymentuser;
	}

	public List<Expenditure> getExpenditures() {
		return expenditures;
	}

	public void setExpenditures(List<Expenditure> expenditures) {
		this.expenditures = expenditures;
	}

	@Override
	public int hashCode() {
		return Objects.hash(expenditures, pay_code, paymentType, paymentuser, remarks, user_name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaymentMode other = (PaymentMode) obj;
		return Objects.equals(expenditures, other.expenditures) && Objects.equals(pay_code, other.pay_code)
				&& Objects.equals(paymentType, other.paymentType) && Objects.equals(paymentuser, other.paymentuser)
				&& Objects.equals(remarks, other.remarks) && Objects.equals(user_name, other.user_name);
	}

	@Override
	public String toString() {
		return "PaymentMode [pay_code=" + pay_code + ", user_name=" + user_name + ", paymentType=" + paymentType
				+ ", remarks=" + remarks + ", paymentuser=" + paymentuser + ", expenditures=" + expenditures + "]";
	}

}