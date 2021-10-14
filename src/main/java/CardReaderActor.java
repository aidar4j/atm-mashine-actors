import io.vlingo.xoom.actors.Actor;

public class CardReaderActor extends Actor implements CardReader{
    private CardReader self;

    public CardReaderActor() {
        this.self = selfAs(CardReader.class);
    }

    @Override
    public void ejectCard(Atm atm) {
        logger().info("Eject card inside CardReader");

        atm.receiveCard();
    }

}
