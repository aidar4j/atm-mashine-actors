package playground;

import io.vlingo.xoom.actors.Actor;
import io.vlingo.xoom.actors.testkit.TestUntil;

public class AtmActor extends Actor implements Atm {
    private final Atm self;
    private boolean cardInserted;
    private final TestUntil until;
    private boolean isPinCorrect;

    public AtmActor(final TestUntil until) {
        this.until = until;
        this.cardInserted = false;
        this.isPinCorrect = false;
        this.self = selfAs(Atm.class);
    }

    @Override
    public void insertCard(final CardReader cardReader) {
        logger().info("Inserting Card");
        cardReader.readCard(self);
    }

    @Override
    public void receiveCard(final CardReader cardReader) {
        cardInserted = true;
        logger().info("Card Received is " + cardInserted);
    }

    @Override
    public void verifyPin(final Bank bank) {
        logger().info("Verifying PIN");
        bank.checkPin(self);
    }

    @Override
    public void acceptPin() {
        logger().info("Accepting PIN");
        isPinCorrect = true;
        logger().info("isPinCorrect " + isPinCorrect);
    }

    @Override
    public void declinePin() {
        logger().info("Declining PIN");
        logger().info("isPinCorrect is " + isPinCorrect);
        self.stop();
    }

    @Override
    protected void afterStop() {
        logger().info("playground.AtmActor " + address() + " just stopped!");
        until.happened();
        super.afterStop();
    }
}
