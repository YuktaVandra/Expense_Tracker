package com.grownited.Dto;

import java.math.BigDecimal;
import java.util.Date;

public class IncomeDto {
	
private Integer incomeId;
	
	private Integer accountId;
	
	private Integer userId;
	
	private String incomeTitle;
	
	private BigDecimal incomeAmount;


	private String description;
	
	
	private Boolean status;
	
	private Date transactionDate;
	
	private String firstName;
	
	private String accountTitle;
	
	private BigDecimal accountAmount;

	public IncomeDto(Integer incomeId, Integer accountId, Integer userId, String incomeTitle, BigDecimal incomeAmount,
			String description, Boolean status, Date transactionDate, String firstName, String accountTitle,
			BigDecimal accountAmount) {
		super();
		this.incomeId = incomeId;
		this.accountId = accountId;
		this.userId = userId;
		this.incomeTitle = incomeTitle;
		this.incomeAmount = incomeAmount;
		this.description = description;
		this.status = status;
		this.transactionDate = transactionDate;
		this.firstName = firstName;
		this.accountTitle = accountTitle;
		this.accountAmount = accountAmount;
	}

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

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getAccountTitle() {
		return accountTitle;
	}

	public void setAccountTitle(String accountTitle) {
		this.accountTitle = accountTitle;
	}

	public BigDecimal getAccountAmount() {
		return accountAmount;
	}

	public void setAccountAmount(BigDecimal accountAmount) {
		this.accountAmount = accountAmount;
	}

	
}
