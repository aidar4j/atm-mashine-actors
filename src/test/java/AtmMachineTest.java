import io.vlingo.xoom.actors.World;
import io.vlingo.xoom.actors.testkit.TestUntil;
import org.junit.Test;

public class AtmMachineTest {

    @Test
    public void testPlayPingPong() {
        final World world = World.startWithDefaults("playground");
        final TestUntil until = TestUntil.happenings(1);
        final Atm atm = world.actorFor(Atm.class, AtmActor.class, until);
        final CardReader cardReader = world.actorFor(CardReader.class, CardReaderActor.class);

        atm.ejectCard(cardReader);

        until.completes();

        world.terminate();
    }
}
