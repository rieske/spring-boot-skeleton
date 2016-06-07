package lt.rieske.skeleton.resources;

import lt.rieske.skeleton.api.ApiObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping(value = "api")
public class ExampleResource {
	
	private final Random random = new Random();

	@RequestMapping(value = "/random", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiObject randomObject() {
		return new ApiObject(String.valueOf(random.nextInt()));
	}

	@RequestMapping(value = "/object/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiObject getObject(@PathVariable String id) {
		return new ApiObject(id);
	}
}
