package lt.rieske.skeleton.resources;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

class ExampleResourceTest {

	private ExampleResource controller = new ExampleResource();

	@BeforeEach
	void setUp() {
		RestAssuredMockMvc.standaloneSetup(controller);
		RestAssuredMockMvc.enableLoggingOfRequestAndResponseIfValidationFails();
	}

	@Test
	void returnsDomainObjectWithGivenId() {
		// @formatter:off
		when().
			get("/api/object/abcde54321").
		then().
			statusCode(HttpStatus.SC_OK).
			body(equalTo("{\"id\":\"abcde54321\"}"));
		// @formatter:on
	}

	@Test
	void returnsRandomDomainObject() {
		// @formatter:off
		when().
			get("/api/random").
		then().
			statusCode(HttpStatus.SC_OK).
			body(notNullValue());
		// @formatter:off
	}
}
