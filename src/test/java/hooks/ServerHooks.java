package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import nicebank.AtmServer;
import nicebank.CashSlot;
import support.TestAccount;


public class ServerHooks {
    public final static int PORT = 8887;
    private final TestAccount account;
    private final CashSlot cashSlot;
    private AtmServer server;
    public ServerHooks(TestAccount account, CashSlot cashSlot) {
        this.account = account;
        this.cashSlot = cashSlot;
    }
    @Before
    public void startServer() throws Exception {
        server = new AtmServer(PORT, cashSlot, account.getAccount());
        server.start();
        System.out.println("Server started");
    }

    @After
    public void stopServer() throws Exception {
        server.stop();
    }
}
