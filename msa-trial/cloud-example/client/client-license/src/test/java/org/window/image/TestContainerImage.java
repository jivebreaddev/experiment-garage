package org.window.image;

import org.testcontainers.utility.DockerImageName;

// Container Image Delcaration
// 1.
public enum TestContainerImage {
    POSTGRES("postgres:9.6.12"), ORGANIZATION("jivebreaddev/organization")
    ,CONFIG("jivebreaddev/license-config");

    private final DockerImageName dockerImageName;

    TestContainerImage(String dockerImageName) {
        this.dockerImageName = DockerImageName.parse(dockerImageName);
    }

    public DockerImageName getDockerImageName() {
        return dockerImageName;
    }
}
