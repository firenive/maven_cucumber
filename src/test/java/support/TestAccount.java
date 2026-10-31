package support;

import nicebank.Account;
public class TestAccount {
    private final Account account;
    public TestAccount(TestDatabase database) {
       account = new Account(1234);
       account.saveIt();

    }
    public Account getAccount() {
        return account;
    }
}
