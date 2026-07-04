package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import nicebank.AtmServer;
import support.KnowsTheDomain;

public class ServerHooks {
    private KnowsTheDomain helper;
    public final static int PORT = 8887;
    private AtmServer server;
    public ServerHooks(KnowsTheDomain helper) {
        this.helper = helper;
    }
    @Before
    public void startServer() throws Exception {
        server = new AtmServer(PORT, helper.getCashSlot(), helper.getMyAccount());
        server.start();
        System.out.println("Server started");
    }

    @After
    public void stopServer() throws Exception {
        server.stop();
    }
}
