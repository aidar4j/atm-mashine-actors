package actors;

import io.vlingo.xoom.actors.Stoppable;

public interface CardReader extends Stoppable {
    void readCard(final Atm atm, final Card card);
    void checkBankName(final Atm atm, final Card card, String bankName);
    void checkPin(final Atm atm, final Card card, String pin, String typedPin);
}
