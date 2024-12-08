package com.example.license.service.dto;

import com.example.license.model.License;

public record LicenseCreationResponse(String licenseId) {

  public static LicenseCreationResponse toLicenseCreationResponse(License license) {
    return new LicenseCreationResponse(license.getLicenseId());
  }
}
