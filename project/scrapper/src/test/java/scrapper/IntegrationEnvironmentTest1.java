package scrapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;

public class IntegrationEnvironmentTest1 {

    @Test
    public void testIntegrationEnvironment() {
        PostgreSQLContainer<?> container = IntegrationEnvironment.getInstance();
        Assertions.assertTrue(container.isRunning(), "Container should be running");
    }

}
