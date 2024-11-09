package com.example.license.model;


public class License {

	private int id;
	private String licenseId;
	private String description;
	private String organizationId;
	private String productName;
	private String licenseType;

	public void setId(int id) {
		this.id = id;
	}

	public void setLicenseId(String licenseId) {
		this.licenseId = licenseId;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}
}
