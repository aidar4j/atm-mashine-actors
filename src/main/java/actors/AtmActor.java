package actors;

import io.vlingo.xoom.actors.Actor;
import io.vlingo.xoom.actors.testkit.TestUntil;

public class AtmActor extends Actor implements Atm {
    private final Atm self;
    private boolean cardAccepted;
    private final TestUntil until;
    private boolean isPinCorrect;
    private Long money;

    public AtmActor(final TestUntil until) {
        this.until = until;
        this.cardAccepted = false;
        this.isPinCorrect = false;
        this.self = selfAs(Atm.class);
        this.money = 0L;
    }

    @Override
    public void insertCard(final CardReader cardReader, final Card card) {
        logger().info("Inserting Card");
        logger().info("money = " + this.money);

        cardReader.readCard(self, card);
    }

    @Override
    public void insertCardWithNullPointer(final CardReader cardReader, final Card card) {
        logger().info("Inserting Card");
        logger().info("money = " + this.money);
        this.money = money + 200;
        logger().info("money = " + this.money);
        this.money = null;

        cardReader.readCard(self, card);
    }

    @Override
    public void acceptCard(final CardReader cardReader, final Card card) {
        cardAccepted = true;
        logger().info("Card is accepted: " + cardAccepted);
    }

    @Override
    public void declineCard(final CardReader cardReader, final Card card) {
        cardAccepted = false;
        logger().info("Card is not accepted: " + cardAccepted);
    }

    @Override
    public void verifyPin(String typedPin, final Card card, final CardReader cardReader) {
        logger().info("Verifying PIN");
        card.sendPin(typedPin, self, cardReader);
    }

    @Override
    public void acceptPin(final CardReader cardReader, final Card card) {
        logger().info("Accepting PIN");
        isPinCorrect = true;
        logger().info("isPinCorrect " + isPinCorrect);
    }

    @Override
    public void declinePin(final CardReader cardReader, final Card card) {
        logger().info("Declining PIN");
        logger().info("isPinCorrect is " + isPinCorrect);
        self.stop();
    }

    @Override
    public void affordMoney(final Bank bank, long money) {
        logger().info("Affording money");

        bank.sendMoney(self, money);
    }

    @Override
    public void declinedAffordMoney() {
        logger().info("Declined affording money, balance is " + this.money);
    }

    @Override
    public void addMoney(long money) {
        logger().info("Adding extra money to ATM money, before adding balance is " + this.money);
        this.money += money;
        logger().info("After adding balance is " + this.money);
    }

    @Override
    protected void afterStop() {
        logger().info("playground.AtmActor " + address() + " just stopped!");
        until.happened();
        super.afterStop();
    }
}
