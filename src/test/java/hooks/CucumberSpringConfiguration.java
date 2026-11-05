package hooks;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.test.context.ContextConfiguration;
import support.SpringTestConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = SpringTestConfiguration.class)
public class CucumberSpringConfiguration {
}
