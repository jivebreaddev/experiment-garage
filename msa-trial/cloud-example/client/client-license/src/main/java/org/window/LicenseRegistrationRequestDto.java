package org.window;

public record LicenseRegistrationRequestDto(String productType, Long quantity, String organizationId) {
}
