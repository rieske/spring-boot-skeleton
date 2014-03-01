package lt.rieske.mvc.rest.model;

public class DomainObject {
    private final String id;

    public DomainObject(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
