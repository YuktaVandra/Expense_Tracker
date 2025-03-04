package com.grownited.Dto;

import java.math.BigDecimal;
import java.util.Date;


public class ExpenseDto {
	
    private Integer expenseId;
	
	private Integer categoryId;
	
	private Integer subcategoryId;
	
	private Integer accountId;
	
	private Integer vendorId;
	
	private Integer userId;
	
	private String expenseTitle;
	
	private BigDecimal expenseAmount;
	
	private String description;
	
	private Boolean status;
	
	private Date transactionDate;
	
	private String firstName;
	
	private String categoryTitle;
	
	private String subcategoryTitle;
	
	private String accountTitle;
	
	private String vendorTitle;
	
	private BigDecimal accountAmount;

	public ExpenseDto(Integer expenseId, Integer categoryId, Integer subcategoryId, Integer accountId, Integer vendorId,
			Integer userId, String expenseTitle, BigDecimal expenseAmount, String description, Boolean status,
			Date transactionDate, String firstName, String categoryTitle, String subcategoryTitle, String accountTitle,
			String vendorTitle, BigDecimal accountAmount) {
		super();
		this.expenseId = expenseId;
		this.categoryId = categoryId;
		this.subcategoryId = subcategoryId;
		this.accountId = accountId;
		this.vendorId = vendorId;
		this.userId = userId;
		this.expenseTitle = expenseTitle;
		this.expenseAmount = expenseAmount;
		this.description = description;
		this.status = status;
		this.transactionDate = transactionDate;
		this.firstName = firstName;
		this.categoryTitle = categoryTitle;
		this.subcategoryTitle = subcategoryTitle;
		this.accountTitle = accountTitle;
		this.vendorTitle = vendorTitle;
		this.accountAmount = accountAmount;
	}

	public Integer getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(Integer expenseId) {
		this.expenseId = expenseId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getSubcategoryId() {
		return subcategoryId;
	}

	public void setSubcategoryId(Integer subcategoryId) {
		this.subcategoryId = subcategoryId;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Integer getVendorId() {
		return vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getExpenseTitle() {
		return expenseTitle;
	}

	public void setExpenseTitle(String expenseTitle) {
		this.expenseTitle = expenseTitle;
	}

	public BigDecimal getExpenseAmount() {
		return expenseAmount;
	}

	public void setExpenseAmount(BigDecimal expenseAmount) {
		this.expenseAmount = expenseAmount;
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

	public String getCategoryTitle() {
		return categoryTitle;
	}

	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	public String getSubcategoryTitle() {
		return subcategoryTitle;
	}

	public void setSubcategoryTitle(String subcategoryTitle) {
		this.subcategoryTitle = subcategoryTitle;
	}

	public String getAccountTitle() {
		return accountTitle;
	}

	public void setAccountTitle(String accountTitle) {
		this.accountTitle = accountTitle;
	}

	public String getVendorTitle() {
		return vendorTitle;
	}

	public void setVendorTitle(String vendorTitle) {
		this.vendorTitle = vendorTitle;
	}

	public BigDecimal getAccountAmount() {
		return accountAmount;
	}

	public void setAccountAmount(BigDecimal accountAmount) {
		this.accountAmount = accountAmount;
	}

	
}
