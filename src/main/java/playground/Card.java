package playground;

import io.vlingo.xoom.actors.Stoppable;

public interface Card extends Stoppable {
    void sendBankName(final Atm atm, final CardReader cardReader);
    void sendPin(String typedPin, final Atm atm, final CardReader cardReader);
}
