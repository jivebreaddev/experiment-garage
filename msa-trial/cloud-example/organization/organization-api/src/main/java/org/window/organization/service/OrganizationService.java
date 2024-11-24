package org.window.organization.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import domain.Organization;
import domain.OrganizationRepository;

import java.util.UUID;

@Service
public class OrganizationService {
    private static final Logger logger = LoggerFactory.getLogger(OrganizationService.class);

    private final OrganizationRepository repository;

    OrganizationService(OrganizationRepository organizationRepository) {
        this.repository = organizationRepository;
    }

    public Organization findById(String organizationId) {
        Organization opt = repository.findById(organizationId)
                .orElseThrow(RuntimeException::new);
        return opt;
    }

    public Organization create(Organization organization) {
        organization.setId(UUID.randomUUID().toString());
        organization = repository.save(organization);
        return organization;

    }

    public void update(Organization organization) {
        repository.save(organization);
    }

    public void delete(String organizationId) {
        repository.deleteById(organizationId);
    }

    @SuppressWarnings("unused")
    private void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
    }
}
