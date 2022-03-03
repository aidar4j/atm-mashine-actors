package actors;

import io.vlingo.xoom.actors.*;

public class MainSupervisorActor extends Actor implements Supervisor {

    @Override
    public void inform(Throwable throwable, Supervised supervised) {
        if (throwable.getClass().equals(NullPointerException.class)) {
            supervised.restartWithin(supervisionStrategy().period(),
                    supervisionStrategy().intensity(), supervisionStrategy().scope());
        } else if (throwable.getClass().equals(ArithmeticException.class)) {
            supervised.resume();
        } else if (throwable.getClass().equals(IllegalArgumentException.class)) {
            supervised.stop(supervisionStrategy().scope());
        } else {
            supervised.restartWithin(supervisionStrategy().period(),
                    supervisionStrategy().intensity(), supervisionStrategy().scope());
        }
    }

    @Override
    public SupervisionStrategy supervisionStrategy() {
        return new SupervisionStrategy() {
            @Override
            public int intensity() {
                return 5;
            }

            @Override
            public long period() {
                return 2000;
            }

            @Override
            public Scope scope() {
                return Scope.One;
            }
        };
    }

    @Override
    public Supervisor supervisor() {
        return this;
    }
}
