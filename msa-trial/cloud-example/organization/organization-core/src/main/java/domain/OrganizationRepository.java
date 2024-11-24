package domain;

import java.util.Optional;

public interface OrganizationRepository {
    Optional<Organization> findById(String organizationId);

    Organization save(Organization organization);

    void deleteById(String organizationId);

}
