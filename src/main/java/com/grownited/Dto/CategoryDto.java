package com.grownited.Dto;

public class CategoryDto {
	
	private Integer categoryId;
	private Integer userId;
	private String categoryTitle;
	private String firstName;
	
	
	
	
	public CategoryDto(Integer categoryId, Integer userId, String categoryTitle, String firstName) {
		super();
		this.categoryId = categoryId;
		this.userId = userId;
		this.categoryTitle = categoryTitle;
		this.firstName = firstName;
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
	
	
	

}
