package com.grownited.Dto;

public class VendorDto {
	
    private Integer vendorId;
	
	private Integer userId;
	
	private String vendorTitle;
	
	private String firstName;
	
	private String email;

	public VendorDto(Integer vendorId, Integer userId, String vendorTitle, String firstName, String email) {
		super();
		this.vendorId = vendorId;
		this.userId = userId;
		this.vendorTitle = vendorTitle;
		this.firstName = firstName;
		this.email = email;
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

	public String getVendorTitle() {
		return vendorTitle;
	}

	public void setVendorTitle(String vendorTitle) {
		this.vendorTitle = vendorTitle;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
