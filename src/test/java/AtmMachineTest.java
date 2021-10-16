import io.vlingo.xoom.actors.World;
import io.vlingo.xoom.actors.testkit.TestUntil;
import org.junit.Test;
import playground.*;

public class AtmMachineTest {

    @Test
    public void test() {
        final World world = World.startWithDefaults("playground");
        final TestUntil until = TestUntil.happenings(1);
        final Atm atm = world.actorFor(Atm.class, AtmActor.class, until);
        final CardReader cardReader = world.actorFor(CardReader.class, CardReaderActor.class);
        final Bank bank = world.actorFor(Bank.class, BankActor.class);

        atm.insertCard(cardReader);
        atm.verifyPin(bank);

        until.completes();

        world.terminate();
    }
}
