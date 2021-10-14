import io.vlingo.xoom.actors.Stoppable;

public interface Atm extends Stoppable {
    void ejectCard(final CardReader cardReader);
    void receiveCard();
}
