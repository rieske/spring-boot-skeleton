package lt.rieske.skeleton;

import com.palantir.docker.compose.DockerComposeRule;
import com.palantir.docker.compose.connection.waiting.HealthChecks;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.ClassRule;

public abstract class ComponentTestHarness {

    private static final String SERVICE_UNDER_TEST = "service";

    private static final int SERVICE_PORT = 8080;
    private static final String SERVICE_URI_FORMAT = "http://$HOST:$EXTERNAL_PORT";

    @ClassRule
    public static DockerComposeRule docker = DockerComposeRule.builder()
            .file("docker-compose.yml")
            .waitingForService("service", HealthChecks.toHaveAllPortsOpen())
            .waitingForService("service", HealthChecks.toRespond2xxOverHttp(SERVICE_PORT,
                    port -> port.inFormat(SERVICE_URI_FORMAT + "/actuator/health")))
            .build();

    @Before
    public void setUpEnvironment() {
        RestAssured.baseURI = docker.containers().container(SERVICE_UNDER_TEST)
                .port(SERVICE_PORT).inFormat(SERVICE_URI_FORMAT);
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
