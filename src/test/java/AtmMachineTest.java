
import io.vlingo.xoom.actors.Configuration;
import io.vlingo.xoom.actors.World;
import io.vlingo.xoom.actors.plugin.supervision.CommonSupervisorsPlugin;
import io.vlingo.xoom.actors.testkit.TestUntil;
import org.junit.Test;
import actors.*;

public class AtmMachineTest {

    Configuration configuration =
            Configuration
                    .define()
                    .with(CommonSupervisorsPlugin.CommonSupervisorsPluginConfiguration
                            .define()
                            .supervisor("default", "mainSupervisor", Atm.class, MainSupervisorActor.class)
                            .supervisor("default", "mainSupervisor", CardReader.class, MainSupervisorActor.class)
                            .supervisor("default", "mainSupervisor", Bank.class, MainSupervisorActor.class)
                            .supervisor("default", "mainSupervisor", Card.class, MainSupervisorActor.class)
                    );

    @Test
    public void checkBankNameTest_withoutException() {
        final World world = World.start("actors", configuration);
        final TestUntil until = TestUntil.happenings(1);
        final Atm atm = world.actorFor(Atm.class, AtmActor.class, until);
        final CardReader cardReader = world.actorFor(CardReader.class, CardReaderActor.class, "Money Bank");
        final Card card = world.actorFor(Card.class, CardActor.class, "1111", "Money Bank");

        atm.insertCard(cardReader, card);

        until.completes();

        world.terminate();
    }

    @Test
    public void checkBankNameTest_withException() {
        final World world = World.start("actors", configuration);
        final TestUntil until = TestUntil.happenings(1);
        final Atm atm = world.actorFor(Atm.class, AtmActor.class, until);
        final CardReader cardReader = world.actorFor(CardReader.class, CardReaderActor.class, "Money Bank");
        final Bank bank = world.actorFor(Bank.class, BankActor.class, 20000);
        final Card card = world.actorFor(Card.class, CardActor.class, "1111", "Money Bank");

        atm.insertCardWithNullPointer(cardReader, card);
        atm.affordMoney(bank, 500);
        pauseThisThreadForSeconds(5);

        atm.verifyPin("1111", card, cardReader);
        pauseThisThreadForSeconds(5);

        atm.affordMoney(bank, 213);
        pauseThisThreadForSeconds(5);

        atm.verifyPin("1121", card, cardReader);
        pauseThisThreadForSeconds(5);

        until.completes();

        world.terminate();
    }

    private void pauseThisThreadForSeconds(int sec) {
        try {
            Thread.sleep(sec * 1000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
