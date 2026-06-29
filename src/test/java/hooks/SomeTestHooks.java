package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class SomeTestHooks {
    @Before
    public void beforeCallingScenario() {
        System.out.println("************** About to start the scenario.");
    }

    @After
    public void afterCallingScenario(Scenario scenario) {
        System.out.println("************** Just finished running scenario: "
        + scenario.getStatus());
    }
}
