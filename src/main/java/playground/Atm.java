package playground;

import io.vlingo.xoom.actors.Stoppable;

public interface Atm extends Stoppable {
    void insertCard(final CardReader cardReader, final Card card);
    void insertCardWithNullPointer(final CardReader cardReader, final Card card);
    void acceptCard(final CardReader cardReader, final Card card);
    void declineCard(final CardReader cardReader, final Card card);
    void verifyPin(String typedPin, final Card card, final CardReader cardReader);
    void acceptPin(final CardReader cardReader, final Card card);
    void declinePin(final CardReader cardReader, final Card card);
    void affordMoney(final Bank bank, long money);
    void declinedAffordMoney();
    void addMoney(long money);
}
