package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import nicebank.Account;
import nicebank.TransactionQueue;
import org.javalite.activejdbc.Base;

public class ResetHooks {
    @Before(order = 1)
    public void reset() {
        TransactionQueue.clear();
    }
//    @After
//    public void rollback() {
//        Base.rollbackTransaction();
//    }
}
