package com.example.license.service.dto;

public record LicenseCreationRequest(String productType, Long quantity, String organizationId) {

}
