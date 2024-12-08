package com.example.license.service;

import static com.example.license.service.dto.LicenseCreationResponse.toLicenseCreationResponse;

import com.example.license.model.License.LicenseBuilder;
import com.example.license.service.dto.LicenseCreationRequest;
import com.example.license.service.dto.LicenseCreationResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import java.util.Random;

import com.example.license.model.License;
import org.springframework.stereotype.Service;
import org.window.LicenseRegistrationRequestDto;
import org.window.LicenseRegistrationResponseDto;
import org.window.client.OrganizationFeignClient;
import org.window.common.SnowflakeGenerator;


@Service
public class LicenseService {

  private final OrganizationFeignClient licenseOrganizationClient;
  private final SnowflakeGenerator snowflakeGenerator;

  protected LicenseService(OrganizationFeignClient organizationFeignClient,
      SnowflakeGenerator snowflakeGenerator) {
    this.licenseOrganizationClient = organizationFeignClient;
    this.snowflakeGenerator = snowflakeGenerator;
  }

  public License getLicense(String licenseId, String organizationId) {
    return null;
  }

  public LicenseCreationResponse createLicense(LicenseCreationRequest creationRequest) {
    LicenseRegistrationResponseDto license = licenseOrganizationClient.registerLicenseToOrganization(
        new LicenseRegistrationRequestDto(creationRequest.productType(), creationRequest.quantity(),
            creationRequest.organizationId()));

    License registeredLicense = LicenseBuilder.aLicense()
        .withId(snowflakeGenerator.nextId())
        .withLicenseId(license.registrationId())
        .withOrganizationId(creationRequest.organizationId())
        .withProductName(creationRequest.productType())
        .build();

    return toLicenseCreationResponse(registeredLicense);
  }

  public String updateLicense(License license, String organizationId) {

    return null;
  }

  public String deleteLicense(String licenseId, String organizationId) {

    return null;

  }

  @CircuitBreaker(name = "myService", fallbackMethod = "fallback")
  public String externalIntegration(String licenseId, String organizationId) {
    return null;
  }

  public String fallback(Throwable t) {
    return "Fallback response due to: " + t.getMessage();
  }
}
