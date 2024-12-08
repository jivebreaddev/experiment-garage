package org.window.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.window.LicenseRegistrationRequestDto;
import org.window.LicenseRegistrationResponseDto;

@FeignClient("organization")
public interface OrganizationFeignClient {
    @RequestMapping(
            method= RequestMethod.POST,
            value="/v1/organization/license/register",
            consumes="application/json")
    LicenseRegistrationResponseDto registerLicenseToOrganization(@RequestBody LicenseRegistrationRequestDto requestDto);
}
