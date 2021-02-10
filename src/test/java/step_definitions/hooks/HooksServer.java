package step_definitions.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import nicebank.AtmServer;
import nicebank.CashSlot;
import support.KnowsTheAccount;

public class HooksServer {

    public static final int PORT = 8887;
    private AtmServer server;
    private KnowsTheAccount accountHelper;
    private CashSlot cashSlot;

    public HooksServer(KnowsTheAccount accountHelper, CashSlot cashSlot) {
        this.accountHelper = accountHelper;
        this.cashSlot = cashSlot;
    }

    @Before
    public void startServer() throws Exception {
        System.out.println("*********** [ServerHooks] > [@Before] > [startServer()] >: 1) About to create new ATMServer (server) - (helper.getMyAccount())");
        server = new AtmServer( PORT, cashSlot, accountHelper.getMyAccount());
        System.out.println("*********** [ServerHooks] > [@Before] > [startServer()] >: 2) Created new ATMServer (server): " + server);
        //server = new AtmServer(PORT);
        server.start();
    }

    @After
    public void afterRunningScenario(Scenario scenario) throws Exception {
        System.out.println("*********** [ServerHooks] > [@After] > [afterRunningScenario] >: Just finished running scenario: "
                + scenario.getStatus());
        server.stop();
    }
}