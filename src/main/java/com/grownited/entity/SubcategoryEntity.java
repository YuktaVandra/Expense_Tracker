package com.grownited.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "subcategory")
public class SubcategoryEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer subcategoryId;
	
    private Integer categoryId;
	
	private Integer userId;
	
	private String subcategoryTitle;
	
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
	
	
	

}
