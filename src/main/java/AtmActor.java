import io.vlingo.xoom.actors.Actor;
import io.vlingo.xoom.actors.testkit.TestUntil;

public class AtmActor extends Actor implements Atm {
    private final Atm self;
    private int count;
    private Long id;
    private Cash cash;
    private CardReader cardReader;
    private boolean cardReceived;
    private final TestUntil until;

    public AtmActor(final TestUntil until) {
        this.until = until;
        this.cardReceived = false;
        this.count = 0;
        this.self = selfAs(Atm.class);
    }

    @Override
    public void ejectCard(final CardReader cardReader) {
        ++count;
        logger().info("count " + count);
        logger().info("Ejecting Card");
        cardReader.ejectCard(self);
    }

    @Override
    public void receiveCard() {
        cardReceived = true;
        logger().info("Card Received");
    }
}
