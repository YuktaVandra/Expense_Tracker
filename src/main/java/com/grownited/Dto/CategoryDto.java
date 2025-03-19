package com.grownited.Dto;

public class CategoryDto {
	
	private Integer categoryId;
	private Integer userId;
	private String categoryTitle;
	private String firstName;
	private String lastName;
	private String email;
	public CategoryDto(Integer categoryId, Integer userId, String categoryTitle, String firstName, String lastName,
			String email) {
		super();
		this.categoryId = categoryId;
		this.userId = userId;
		this.categoryTitle = categoryTitle;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getCategoryTitle() {
		return categoryTitle;
	}
	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
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
	
	
}
