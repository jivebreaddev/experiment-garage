package org.window;

import domain.Organization;
import domain.OrganizationRepository;
import org.springframework.stereotype.Component;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
class OrganizationDefaultRepository implements OrganizationRepository {
    private final Map<String, Organization> organizationMap;

    OrganizationDefaultRepository() {
        this.organizationMap = new HashMap<String, Organization>();
    }

    @Override
    public Optional<Organization> findById(String organizationId) {
        return Optional.ofNullable(organizationMap.get(organizationId));
    }

    @Override
    public Organization save(Organization organization) {
        return organizationMap.put(organization.getId(), organization);
    }

    @Override
    public void deleteById(String organizationId) {
        organizationMap.remove(organizationId);
    }
}
