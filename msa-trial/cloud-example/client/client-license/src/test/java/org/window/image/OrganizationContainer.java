package org.window.image;

import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.utility.DockerImageName;

public class OrganizationContainer extends GenericContainer<OrganizationContainer> {

    private static final int PORT = 8080;

    public OrganizationContainer(DockerImageName dockerImageName) {
        super(dockerImageName);
    }

    @Override
    protected void configure() {
        addExposedPort(PORT);
        waitingFor(Wait.forHttp("/actuator")
                .forStatusCode(200));
    }

    public String getOrganizationUrl(){
        return String.format("http://%s:%d", this.getHost(), this.getMappedPort(PORT));
    }
}
