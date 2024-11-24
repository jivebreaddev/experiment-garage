package org.window.client;

import org.junit.Rule;
import org.junit.rules.RuleChain;
import org.testcontainers.containers.Network;
import org.testcontainers.containers.PostgreSQLContainer;
import org.window.image.ConfigurationContainer;
import org.window.image.OrganizationContainer;
import org.window.image.TestContainerImage;

// 싱글톤으로 만들어서 하나의 컨테이너로 사용하기 위한 방법

public abstract class AbstractContainerBaseTest {
    private static final String POSTGRES_USERNAME = "postgres";
    private static final String POSTGRES_PASSWORD = "postgres";
    private static final String POSTGRES_DATABASE = "ostock_dev";
    private static PostgreSQLContainer<?> postgreSQLContainer;
    private static OrganizationContainer organizationContainer;
    private static ConfigurationContainer configurationContainer;
    private static Network sharedNetwork = Network.newNetwork();

    // 컨테이너들을 설정합니다.
    // 1. shared Network 설정
    // 2. db credential 설정
    // 3. 순서 설정
    static {
        postgreSQLContainer = new PostgreSQLContainer<>(
                TestContainerImage.POSTGRES.getDockerImageName()
        )
                .withUsername(POSTGRES_USERNAME)
                .withPassword(POSTGRES_PASSWORD)
                .withDatabaseName(POSTGRES_DATABASE)
                .withNetwork(sharedNetwork);
        postgreSQLContainer.start();

        configurationContainer = new ConfigurationContainer(TestContainerImage
                .CONFIG
                .getDockerImageName())
                .withNetwork(sharedNetwork)
                .withNetworkAliases("config-server");

        configurationContainer.start();

        organizationContainer = new OrganizationContainer(TestContainerImage
                .ORGANIZATION
                .getDockerImageName())
                .withNetwork(sharedNetwork)
                .withNetworkAliases("organization-server");
        organizationContainer.start();

    }

    // 컨테이너 실행 순서를 정합니다.
    @Rule
    public RuleChain chain = RuleChain.outerRule(postgreSQLContainer)
            .around(configurationContainer)
            .around(organizationContainer);
}
