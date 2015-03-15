package lt.rieske.mvc.rest.api;

import lt.rieske.mvc.rest.model.DomainObject;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "api")
public class ExampleController {

    @RequestMapping(value = "/random", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public DomainObject randomObject() {
        return new DomainObject(String.valueOf(Math.random()));
    }

    @RequestMapping(value = "/object/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public DomainObject getObject(@PathVariable String id) {
        return new DomainObject(id);
    }
}
