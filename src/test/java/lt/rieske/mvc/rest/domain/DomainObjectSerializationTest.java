package lt.rieske.mvc.rest.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DomainObjectSerializationTest {

	private static final ObjectMapper MAPPER = new ObjectMapper();

	@Test
	public void serializesDomainObjectToJson() throws JsonProcessingException {
		String json = MAPPER.writeValueAsString(new DomainObject("abc123"));

		assertThat(json).isEqualTo("{\"id\":\"abc123\"}");
	}
}
