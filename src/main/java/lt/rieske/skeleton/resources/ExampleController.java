package lt.rieske.skeleton.resources;

import java.util.Random;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lt.rieske.skeleton.api.ApiObject;

@Controller
@RequestMapping(value = "api")
public class ExampleController {
	
	private final Random random = new Random();

	@RequestMapping(value = "/random", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ApiObject randomObject() {
		return new ApiObject(String.valueOf(random.nextInt()));
	}

	@RequestMapping(value = "/object/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ApiObject getObject(@PathVariable String id) {
		return new ApiObject(id);
	}
}
