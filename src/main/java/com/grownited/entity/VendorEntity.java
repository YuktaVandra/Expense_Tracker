package com.grownited.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vendor")
public class VendorEntity {
	 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vendorId;
	
	private Integer userId;
	
	private String vendorTitle;
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
	public String getVendorTitle() {
		return vendorTitle;
	}
	public void setVendorTitle(String vendorTitle) {
		this.vendorTitle = vendorTitle;
	}
	
	
	
	

}
