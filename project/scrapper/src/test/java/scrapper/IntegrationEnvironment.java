package scrapper;

import liquibase.Liquibase;

import java.sql.DriverManager;

import org.testcontainers.containers.PostgreSQLContainer;

import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.database.jvm.JdbcConnection;
import liquibase.resource.ClassLoaderResourceAccessor;

public class IntegrationEnvironment {

    private static PostgreSQLContainer<?> container;

    public static synchronized PostgreSQLContainer<?> getInstance() {
        if (container == null) {
            container = new PostgreSQLContainer<>("postgres:14-alpine")
                    .withDatabaseName("scrapper")
                    .withUsername("Artem")
                    .withPassword("12345");
            container.start();
            // run Liquibase migrations
            runLiquibaseMigrations(container.getJdbcUrl(), container.getUsername(), container.getPassword());
        }
        return container;
    }

    private static void runLiquibaseMigrations(String jdbcUrl, String username, String password) {
        try {
            Liquibase liquibase = new Liquibase("migrations/master.xml", new ClassLoaderResourceAccessor(), new JdbcConnection(
                    DriverManager.getConnection(jdbcUrl, username, password)));
            liquibase.update(new Contexts(), new LabelExpression());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
