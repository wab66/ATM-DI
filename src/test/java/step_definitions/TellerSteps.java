package step_definitions;

import io.cucumber.java.en.When;
import support.KnowsTheTeller;
import support.KnowsTheAccount;

public class TellerSteps {

    double del = 0;
    KnowsTheTeller tellerHelper;
    KnowsTheAccount accountHelper;

    public TellerSteps(KnowsTheTeller tellerHelper, KnowsTheAccount accountHelper) {
        this.tellerHelper = tellerHelper;
        this.accountHelper = accountHelper;
    }

    @When("^I withdraw (\\d+)$")
    public void iWithdraw(int withdrawAmount){
        tellerHelper.getTeller().withdrawFrom(accountHelper.getMyAccount(), withdrawAmount);
    }

}
