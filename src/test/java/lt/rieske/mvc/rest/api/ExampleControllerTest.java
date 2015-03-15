package lt.rieske.mvc.rest.api;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;

@RunWith(MockitoJUnitRunner.class)
public class ExampleControllerTest {

	@InjectMocks
	ExampleController controller;

	@Before
	public void setUp() {
		RestAssuredMockMvc.standaloneSetup(controller);
		RestAssuredMockMvc.enableLoggingOfRequestAndResponseIfValidationFails();
	}

	@Test
	public void returnsDomainObjectWithGivenId() {
		// @formatter:off
		given().
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
		when().
			get("/api/random").
		then().
			statusCode(HttpStatus.SC_OK).
			body(notNullValue());
		// @formatter:o
	}
}
