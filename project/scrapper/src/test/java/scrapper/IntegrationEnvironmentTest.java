package scrapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntegrationEnvironmentTest {

    @Test
    public void testContainerStartup() {
        IntegrationEnvironment.startContainer();

    }
}
