package lt.rieske.mvc.external;

import java.util.Properties;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ServletContextAware;

@Configuration
@ComponentScan("com.mangofactory.swagger.configuration")
public class SwaggerApiDocsConfiguration implements ServletContextAware {

    private ServletContext servletContext;

    @Override
    public void setServletContext(ServletContext servletContext) {
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAA");
        this.servletContext = servletContext;
    }

    @Bean
    public PropertyPlaceholderConfigurer swaggerProperties() {

        Properties properties = new Properties();
        properties.setProperty("documentation.services.basePath", servletContext.getContextPath());
        properties.setProperty("documentation.services.version", "v1");

        PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
        configurer.setProperties(properties);
        configurer.setIgnoreUnresolvablePlaceholders(true);
        return configurer;
    }

}
