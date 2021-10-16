package playground;

import io.vlingo.xoom.actors.Stoppable;

public interface CardReader extends Stoppable {
    void readCard(final Atm atm);
}
