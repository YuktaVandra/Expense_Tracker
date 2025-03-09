package com.grownited.Dto;

import java.math.BigDecimal;

public class AccountDto {
	
	private Integer accountId;
	private Integer userId;
	private String accountTitle;
	private BigDecimal accountAmount;
	private String description;
	private String firstName;
	public AccountDto(Integer accountId, Integer userId, String accountTitle, BigDecimal accountAmount,
			String description, String firstName) {
		super();
		this.accountId = accountId;
		this.userId = userId;
		this.accountTitle = accountTitle;
		this.accountAmount = accountAmount;
		this.description = description;
		this.firstName = firstName;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	
	

}
