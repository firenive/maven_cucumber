package support;

import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import nicebank.Account;
@ScenarioScoped
public class TestAccount {
    private final Account account;
    @Inject
    public TestAccount(TestDatabase database) {
       account = new Account(1234);
       account.saveIt();

    }
    public Account getAccount() {
        return account;
    }
}
