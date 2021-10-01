import io.vlingo.xoom.actors.Actor;
import message.EjectCardMessage;

public class AtmActor extends Actor implements Atm{
    private final Atm self;

    private Long id;
    private Cash cash;

    public AtmActor() {
        self = selfAs(AtmActor.class);
    }

    public void ejectCard(EjectCardMessage ejectCardMessage) {

    }
}
