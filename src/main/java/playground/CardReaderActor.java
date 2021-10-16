package playground;

import io.vlingo.xoom.actors.Actor;

public class CardReaderActor extends Actor implements CardReader{
    private final CardReader self;

    public CardReaderActor() {
        this.self = selfAs(CardReader.class);
    }

    @Override
    public void readCard(Atm atm) {
        logger().info("Reading card inside playground.CardReader");

        atm.receiveCard(self);
    }

}
