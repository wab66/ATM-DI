package support;
import nicebank.Account;
import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.DBException;

public class KnowsTheAccount {
    private Account myAccount;

    public KnowsTheAccount() {
        if (!Base.hasConnection()) {
            Base.open(
                    "com.mysql.jdbc.Driver",
                    "jdbc:mysql://localhost/bank",
                    "teller", "password");
        }

        Account.deleteAll();
    }

    public Account getMyAccount() {
        if (myAccount == null){
            myAccount = new Account(1234);
            myAccount.saveIt();
        }

        return myAccount;
    }
}
