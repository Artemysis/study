package scrapper;

import org.junit.jupiter.api.Test;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.containers.PostgreSQLContainer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Testcontainers
public class IntegrationEnvironmentTest2 {

    @Container
    private static final PostgreSQLContainer<?> container = IntegrationEnvironment.getInstance();

    @Test
    void testContainerIsRunning() throws SQLException {
        try (Connection conn = DriverManager.getConnection(container.getJdbcUrl(), container.getUsername(), container.getPassword())) {
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
