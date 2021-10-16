package playground;

import io.vlingo.xoom.actors.Actor;

public class BankActor extends Actor implements Bank {
//    private final Bank self;
//
//    public BankActor() {
//        self = selfAs(BankActor.class);
//    }

    @Override
    public void checkPin(final Atm atm) {
        logger().info("Checking PIN in Bank");
        atm.acceptPin();
    }
}
