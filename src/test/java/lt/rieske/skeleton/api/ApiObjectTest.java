package lt.rieske.skeleton.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ApiObjectTest {

	private static final ObjectMapper MAPPER = new ObjectMapper();

	@Test
	void serializesDomainObjectToJson() throws JsonProcessingException {
		var json = MAPPER.writeValueAsString(new ApiObject("abc123"));

		assertThat(json).isEqualTo("{\"id\":\"abc123\"}");
	}
}
