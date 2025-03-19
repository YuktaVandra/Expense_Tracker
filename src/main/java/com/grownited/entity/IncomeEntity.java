package com.grownited.entity;

import java.math.BigDecimal;
import java.time.LocalDate;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "income")
public class IncomeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer incomeId;
	
	private Integer accountId;
	
	private Integer userId;
	
	private String incomeTitle;


	private BigDecimal incomeAmount;


	private String description;
	
	
	private String status;
	
	private LocalDate transactionDate;
	
	
	
	public Integer getIncomeId() {
		return incomeId;
	}
	public void setIncomeId(Integer incomeId) {
		this.incomeId = incomeId;
	}
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getIncomeTitle() {
		return incomeTitle;
	}
	public void setIncomeTitle(String incomeTitle) {
		this.incomeTitle = incomeTitle;
	}
	
	public BigDecimal getIncomeAmount() {
		return incomeAmount;
	}
	public void setIncomeAmount(BigDecimal incomeAmount) {
		this.incomeAmount = incomeAmount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}
	
}
	
	
