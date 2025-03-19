package com.grownited.Dto;


public class SubcategoryDto {
	
private Integer subcategoryId;
	
    private Integer categoryId;
	
	private Integer userId;
	
	private String subcategoryTitle;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String categoryTitle;

	public SubcategoryDto(Integer subcategoryId, Integer categoryId, Integer userId, String subcategoryTitle,
			String firstName, String lastName, String email, String categoryTitle) {
		super();
		this.subcategoryId = subcategoryId;
		this.categoryId = categoryId;
		this.userId = userId;
		this.subcategoryTitle = subcategoryTitle;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.categoryTitle = categoryTitle;
	}

	public Integer getSubcategoryId() {
		return subcategoryId;
	}

	public void setSubcategoryId(Integer subcategoryId) {
		this.subcategoryId = subcategoryId;
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

	public String getSubcategoryTitle() {
		return subcategoryTitle;
	}

	public void setSubcategoryTitle(String subcategoryTitle) {
		this.subcategoryTitle = subcategoryTitle;
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

	public String getCategoryTitle() {
		return categoryTitle;
	}

	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	
}
