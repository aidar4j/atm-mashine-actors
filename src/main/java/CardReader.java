import io.vlingo.xoom.actors.Stoppable;

public interface CardReader extends Stoppable {
    void ejectCard(Atm atm);
}
