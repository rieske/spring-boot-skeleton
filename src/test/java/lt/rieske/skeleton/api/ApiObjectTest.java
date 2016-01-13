package lt.rieske.skeleton.api;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lt.rieske.skeleton.api.ApiObject;

public class ApiObjectTest {

	private static final ObjectMapper MAPPER = new ObjectMapper();

	@Test
	public void serializesDomainObjectToJson() throws JsonProcessingException {
		String json = MAPPER.writeValueAsString(new ApiObject("abc123"));

		assertThat(json).isEqualTo("{\"id\":\"abc123\"}");
	}
}
