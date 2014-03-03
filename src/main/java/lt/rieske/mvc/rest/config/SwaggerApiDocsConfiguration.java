package lt.rieske.mvc.rest.config;

import java.util.Properties;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;

import com.mangofactory.swagger.configuration.DocumentationConfig;

@Configuration
@Import(DocumentationConfig.class)
public class SwaggerApiDocsConfiguration {

    private static final String CONTEXT_PATH_PROPERTY = "server.context_path";

    @Bean
    public static PropertyPlaceholderConfigurer swaggerProperties(Environment environment) {
        Properties properties = new Properties();
        properties.setProperty("documentation.services.basePath", environment.getProperty(CONTEXT_PATH_PROPERTY));
        properties.setProperty("documentation.services.version", "v1");

        PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
        configurer.setProperties(properties);
        configurer.setIgnoreUnresolvablePlaceholders(true);
        return configurer;
    }

}
