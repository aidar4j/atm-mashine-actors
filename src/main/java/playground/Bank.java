package playground;

import io.vlingo.xoom.actors.Stoppable;

public interface Bank extends Stoppable {
    void checkPin(final Atm atm);
}
