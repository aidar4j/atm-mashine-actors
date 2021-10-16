package playground;

import io.vlingo.xoom.actors.Stoppable;

public interface Atm extends Stoppable {
    void insertCard(final CardReader cardReader);
    void receiveCard(final CardReader cardReader);
    void verifyPin(final Bank bank);
    void acceptPin();
    void declinePin();
}
