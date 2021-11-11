package playground;

import io.vlingo.xoom.actors.Actor;

public class CardReaderActor extends Actor implements CardReader{
    private final CardReader self;
    private final String bankName;

    public CardReaderActor(String bankName) {
        this.self = selfAs(CardReader.class);
        this.bankName = bankName;
    }

    @Override
    public void readCard(final Atm atm, final Card card) {
        logger().info("Reading card inside of CardReader");

        card.sendBankName(atm, self);
    }

    @Override
    public void checkBankName(final Atm atm, final Card card, String bankName) {
        logger().info("Checking name of the bank on Card in CardReader");
        if (this.bankName.equals(bankName)) {
            logger().info("Bank names matched");
            atm.acceptCard(self, card);
        } else {
            logger().info("Bank names did not match");
            atm.declineCard(self, card);
        }
    }

    @Override
    public void checkPin(final Atm atm, final Card card, String pin, String typedPin) {
        logger().info("Checking pin on Card in CardReader");
        if (pin.equals(typedPin)) {
            logger().info("Pins matched");
            atm.acceptPin(self, card);
        } else {
            logger().info("Pins did not match");
            atm.declinePin(self, card);
        }
    }

}
