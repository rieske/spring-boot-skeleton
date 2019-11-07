package lt.rieske.skeleton;

import io.restassured.RestAssured;
import lt.rieske.skeleton.integration.ExampleEndpointTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.containers.output.Slf4jLogConsumer;
import org.testcontainers.containers.wait.strategy.Wait;

import java.nio.file.Paths;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        SmokeTest.class,
        ExampleEndpointTest.class
})
public class ComponentTestHarness {

    private static final Logger LOG = LoggerFactory.getLogger(ComponentTestHarness.class);

    private static final String SERVICE_CONTAINER = "service_1";
    private static final int SERVICE_PORT = 8080;

    private static DockerComposeContainer environment =
            new DockerComposeContainer(Paths.get("docker-compose.yml").toFile())
                    .withLocalCompose(true)
                    .withLogConsumer(SERVICE_CONTAINER, new Slf4jLogConsumer(LOG).withPrefix(SERVICE_CONTAINER))
                    .withExposedService(SERVICE_CONTAINER, SERVICE_PORT, Wait.forListeningPort())
                    .withExposedService(SERVICE_CONTAINER, SERVICE_PORT, Wait.forHttp("/actuator/health").forStatusCode(200));

    @BeforeClass
    public static void setUp() {
        environment.start();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.baseURI = serviceUrl();
    }

    @AfterClass
    public static void teardown() {
        environment.stop();
    }

    public static String serviceUrl() {
        return String.format("http://%s:%d",
                environment.getServiceHost(SERVICE_CONTAINER, SERVICE_PORT),
                environment.getServicePort(SERVICE_CONTAINER, SERVICE_PORT));
    }

}
