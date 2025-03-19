package com.grownited.Dto;

import java.math.BigDecimal;


public class AccountDto {
	
	private Integer accountId;
	private Integer userId;
	private String accountTitle;
	private BigDecimal accountAmount;
	private String description;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String contactNo ;
	private String status;
	public AccountDto(Integer accountId, Integer userId, String accountTitle, BigDecimal accountAmount,
			String description, String firstName, String lastName, String email, String password, String contactNo,
			String status) {
		super();
		this.accountId = accountId;
		this.userId = userId;
		this.accountTitle = accountTitle;
		this.accountAmount = accountAmount;
		this.description = description;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.contactNo = contactNo;
		this.status = status;
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
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
