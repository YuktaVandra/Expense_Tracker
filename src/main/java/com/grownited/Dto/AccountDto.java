package com.grownited.Dto;

import java.math.BigDecimal;

public class AccountDto {
	
	private Integer accountId;
	private BigDecimal amount;
	private String accountTitle;
	private String description;
	private Integer userId;
	private String firstName;
	public AccountDto(Integer accountId, BigDecimal amount, String accountTitle, String description, Integer userId,
			String firstName) {
		super();
		this.accountId = accountId;
		this.amount = amount;
		this.accountTitle = accountTitle;
		this.description = description;
		this.userId = userId;
		this.firstName = firstName;
	}
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getAccountTitle() {
		return accountTitle;
	}
	public void setAccountTitle(String accountTitle) {
		this.accountTitle = accountTitle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	
}
