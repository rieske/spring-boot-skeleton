package lt.rieske.mvc.rest.integration;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import lt.rieske.mvc.rest.config.Application;

import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jayway.restassured.RestAssured;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest("server.port:0")
public class ExampleEndpointTest {

	@Value("${local.server.port}")
	private int port;

	@Before
	public void setUp() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.port = port;
	}

	@Test
	public void returnsDomainObjectWithGivenId() {
		// @formatter:off
		given().
			auth().basic("user", "password").
		when().
			get("/api/object/abcde54321").
		then().
			statusCode(HttpStatus.SC_OK).
			body(equalTo("{\"id\":\"abcde54321\"}"));
		// @formatter:on
	}

	@Test
	public void returnsRandomDomainObject() {
		// @formatter:off
		given().
			auth().basic("user", "password").
		when().
			get("/api/random").
		then().
			statusCode(HttpStatus.SC_OK).
			body(notNullValue());
		// @formatter:o
	}
	
	@Test
	public void rejectsUnauthenticatedAccessToDomainObject() {
		// @formatter:off
		given().
		when().
			get("/api/object/abcde54321").
		then().
			statusCode(HttpStatus.SC_UNAUTHORIZED);
		// @formatter:on
	}

	@Test
	public void rejectsUnauthenticatedAccessToRandomDomainObject() {
		// @formatter:off
		given().
		when().
			get("/api/random").
		then().
			statusCode(HttpStatus.SC_UNAUTHORIZED);
		// @formatter:o
	}
	
}
