package support;
import nicebank.ITeller;

public class KnowsTheTeller {
    private final AtmUserInterface atmUserInterface;

    public KnowsTheTeller(AtmUserInterface atmUserInterface) {
        this.atmUserInterface = atmUserInterface;
    }

    public ITeller getTeller() {
        return atmUserInterface;
    }
}
