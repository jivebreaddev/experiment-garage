package com.example.license.controller;

import com.example.license.service.dto.LicenseCreationRequest;


import com.example.license.model.License;
import com.example.license.service.LicenseService;
import com.example.license.service.dto.LicenseCreationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/v1/license")
public class LicenseController {

  private final LicenseService licenseService;

  LicenseController(LicenseService licenseService) {
    this.licenseService = licenseService;
  }

  @RequestMapping(value = "/{licenseId}", method = RequestMethod.GET)
  public ResponseEntity<License> getLicense(@PathVariable("organizationId") String organizationId,
      @PathVariable("licenseId") String licenseId) {
    License license = licenseService.getLicense(licenseId, organizationId);

    return ResponseEntity.ok(license);
  }

  @PutMapping
  public ResponseEntity<String> updateLicense(@PathVariable("organizationId") String organizationId,
      @RequestBody License request) {
    return ResponseEntity.ok(licenseService.updateLicense(request, organizationId));
  }

  @PostMapping
  public ResponseEntity<LicenseCreationResponse> createLicense(@RequestBody LicenseCreationRequest request) {
    return ResponseEntity.ok(licenseService.createLicense(request));
  }

  @DeleteMapping(value = "/{licenseId}")
  public ResponseEntity<String> deleteLicense(@PathVariable("organizationId") String organizationId,
      @PathVariable("licenseId") String licenseId) {
    return ResponseEntity.ok(licenseService.deleteLicense(licenseId, organizationId));
  }
}
