package com.example.license.model;


public class License {

  private Long id;
  private String licenseId;
  private String description;
  private String organizationId;
  private String productName;
  private String licenseType;

  public String getLicenseId() {
    return licenseId;
  }
  public static final class LicenseBuilder {

    private Long id;
    private String licenseId;
    private String description;
    private String organizationId;
    private String productName;
    private String licenseType;

    public LicenseBuilder() {
    }

    public static LicenseBuilder aLicense() {
      return new LicenseBuilder();
    }

    public LicenseBuilder withId(Long id) {
      this.id = id;
      return this;
    }

    public LicenseBuilder withLicenseId(String licenseId) {
      this.licenseId = licenseId;
      return this;
    }

    public LicenseBuilder withOrganizationId(String organizationId) {
      this.organizationId = organizationId;
      return this;
    }

    public LicenseBuilder withProductName(String productName) {
      this.productName = productName;
      return this;
    }


    public License build() {
      License license = new License();
      license.organizationId = this.organizationId;
      license.productName = this.productName;
      license.licenseType = this.licenseType;
      license.id = this.id;
      license.licenseId = this.licenseId;
      license.description = this.description;
      return license;
    }


  }
}
