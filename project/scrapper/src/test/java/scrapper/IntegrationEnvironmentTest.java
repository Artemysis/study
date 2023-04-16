package scrapper;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Testcontainers
public class IntegrationEnvironmentTest {
  @Container
  private static final PostgreSQLContainer<?> POSTGRES_CONTAINER =
      new PostgreSQLContainer<>(DockerImageName.parse("postgres:14-alpine"))
          .withDatabaseName("scrapper")
          .withUsername("Artem")
          .withPassword("12345");

  @Test
  void testContainerStarted() {
      assertTrue(POSTGRES_CONTAINER.isRunning());
  }
}