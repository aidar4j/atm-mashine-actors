package actors;

import io.vlingo.xoom.actors.Actor;

public class CardActor extends Actor implements Card {
    private final String pin;
    private final String bankName;
    private final Card self;

    public CardActor(final String pin, final String bankName) {
        this.self = selfAs(Card.class);
        this.pin = pin;
        this.bankName = bankName;
    }

    @Override
    public void sendBankName(final Atm atm, final CardReader cardReader) {
        logger().info("Sending bank name to CardReader");

        cardReader.checkBankName(atm, self, bankName);
    }

    @Override
    public void sendPin(String typedPin, final Atm atm, final CardReader cardReader) {
        logger().info("Sending pin to CardReader");

        cardReader.checkPin(atm, self, pin, typedPin);
    }
}
