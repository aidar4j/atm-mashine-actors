package playground;

import io.vlingo.xoom.actors.Stoppable;

public interface Bank extends Stoppable {
    void sendMoney(final Atm atm, long money);
}
