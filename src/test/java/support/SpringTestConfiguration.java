package support;

import io.cucumber.spring.ScenarioScope;
import nicebank.CashSlot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ScopedProxyMode;

@Configuration
public class SpringTestConfiguration {

    @Bean
    @ScenarioScope(proxyMode = ScopedProxyMode.NO)
    public TestDatabase testDatabase() {
        return new TestDatabase();
    }

    @Bean
    @ScenarioScope(proxyMode = ScopedProxyMode.NO)
    public TestAccount testAccount(TestDatabase database) {
        return new TestAccount(database);
    }

    @Bean
    @ScenarioScope(proxyMode = ScopedProxyMode.NO)
    public CashSlot cashSlot() {
        return new CashSlot();
    }

    @Bean
    @ScenarioScope(proxyMode = ScopedProxyMode.NO)
    public MyWebDriver myWebDriver() {
        return new MyWebDriver();
    }

    @Bean
    @ScenarioScope(proxyMode = ScopedProxyMode.NO)
    public AtmUserInterface atmUserInterface(MyWebDriver webDriver) {
        return new AtmUserInterface(webDriver);
    }
}
