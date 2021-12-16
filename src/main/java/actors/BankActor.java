package actors;

import io.vlingo.xoom.actors.Actor;

public class BankActor extends Actor implements Bank {
    private final Bank self;
    private long money;

    public BankActor(long money) {
        this.money = money;
        self = selfAs(Bank.class);
    }

    @Override
    public void sendMoney(final Atm atm, long money) {
        logger().info("Sending money to ATM");

        if(money>10000 || money > this.money) {
            logger().info("DECLINED: Affording money is more than 10K or there is no enough money in Bank");

            atm.declinedAffordMoney();

            return;
        }

        logger().info("APPROVED: " + money + " will be sent to ATM");
        atm.addMoney(money);
    }
}
