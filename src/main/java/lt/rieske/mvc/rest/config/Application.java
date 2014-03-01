package lt.rieske.mvc.rest.config;

import lt.rieske.mvc.external.SwaggerApiDocsConfiguration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages={"lt.rieske.mvc.rest"})
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        SpringApplicationBuilder application = new SpringApplicationBuilder();
        application.sources(Application.class).child(Application.class, SwaggerApiDocsConfiguration.class).run(args);
    }
}