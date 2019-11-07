package lt.rieske.skeleton;

import org.junit.Test;

import static io.restassured.RestAssured.when;

public class SmokeTest {

    @Test
    public void serviceStarts() {
        // @formatter:off
        when()
            .get("/actuator/health")
        .then()
            .statusCode(200);
        // @formatter:on
    }

}
