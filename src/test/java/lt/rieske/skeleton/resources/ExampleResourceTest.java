package lt.rieske.skeleton.resources;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(MockitoJUnitRunner.class)
public class ExampleResourceTest {

	@InjectMocks
	ExampleResource controller;

	@Before
	public void setUp() {
		RestAssuredMockMvc.standaloneSetup(controller);
		RestAssuredMockMvc.enableLoggingOfRequestAndResponseIfValidationFails();
	}

	@Test
	public void returnsDomainObjectWithGivenId() {
		// @formatter:off
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
		when().
			get("/api/random").
		then().
			statusCode(HttpStatus.SC_OK).
			body(notNullValue());
		// @formatter:off
	}
}
