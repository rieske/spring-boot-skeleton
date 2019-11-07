package lt.rieske.skeleton.integration;

import org.junit.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;


public class ExampleEndpointTest {

	@Test
	public void returnsDomainObjectWithGivenId() {
		// @formatter:off
		when().
			get("/api/object/abcde54321").
		then().
			statusCode(200).
			body(equalTo("{\"id\":\"abcde54321\"}"));
		// @formatter:on
	}

	@Test
	public void returnsRandomDomainObject() {
		// @formatter:off
		when().
			get("/api/random").
		then().
			statusCode(200).
			body(notNullValue());
		// @formatter:o
	}
	
}
