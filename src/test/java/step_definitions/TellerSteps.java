package step_definitions;

import io.cucumber.java.en.When;
import nicebank.Teller;
import support.KnowsTheAccount;
import support.AtmUserInterface;

public class TellerSteps {

    KnowsTheAccount accountHelper;
    Teller teller;

    public TellerSteps(AtmUserInterface teller, KnowsTheAccount accountHelper) {
        this.teller = teller;
        this.accountHelper = accountHelper;
    }

    @When("^I withdraw (\\d+)$")
    public void iWithdraw(int withdrawAmount){
        teller.withdrawFrom(accountHelper.getMyAccount(), withdrawAmount);
    }

}
