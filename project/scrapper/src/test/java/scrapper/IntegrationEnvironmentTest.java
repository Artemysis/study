package scrapper;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Testcontainers
public class IntegrationEnvironmentTest {
  @Container
  private static final PostgreSQLContainer<?> POSTGRES_CONTAINER =
      new PostgreSQLContainer<>(DockerImageName.parse("postgres:14-alpine"))
          .withDatabaseName("scrapper")
          .withUsername("Artem")
          .withPassword("12345");

  @Test
  void testCreateTable() throws SQLException {
      try (Connection connection = IntegrationEnvironment.getConnection();
           Statement statement = connection.createStatement()) {
          statement.execute("CREATE TABLE IF NOT EXISTS test_table (id SERIAL PRIMARY KEY, name VARCHAR(255) NOT NULL)");
          ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM test_table");
          assertTrue(resultSet.next());
          assertEquals(0, resultSet.getInt(1));
      }
  }

  }
