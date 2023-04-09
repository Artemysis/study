package scrapper;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.sql.Connection;
import java.sql.DriverManager;

@Testcontainers
public class IntegrationEnvironmentTest {

    @Container
    private static PostgreSQLContainer<?> postgres = IntegrationEnvironment.getInstance();

    @Test
    void testContainer() throws Exception {
        assert postgres.isRunning();

        try (Connection conn = DriverManager.getConnection(postgres.getJdbcUrl(), postgres.getUsername(), postgres.getPassword())) {
            conn.createStatement().execute("SELECT 1");
        }
    }
}
