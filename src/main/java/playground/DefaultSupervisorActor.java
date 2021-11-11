package playground;

import io.vlingo.xoom.actors.Actor;
import io.vlingo.xoom.actors.Supervised;
import io.vlingo.xoom.actors.SupervisionStrategy;
import io.vlingo.xoom.actors.Supervisor;

public class DefaultSupervisorActor extends Actor implements Supervisor {

    @Override
    public void inform(Throwable throwable, Supervised supervised) {
        if (throwable.getClass().equals(NullPointerException.class)) {
            supervised.restartWithin(supervisionStrategy().period(), supervisionStrategy().intensity(), supervisionStrategy().scope());
        } else if (throwable.getClass().equals(ArithmeticException.class)) {
            supervised.resume();
        } else if (throwable.getClass().equals(IllegalArgumentException.class)) {
            supervised.stop(supervisionStrategy().scope());
        } else {
            supervised.escalate();
        }


//        switch (throwable.getClass().getName()) {
//            case "java.lang.NullPointerException": supervised.restartWithin(supervisionStrategy().period(), supervisionStrategy().intensity(), supervisionStrategy().scope()); break;
//            case "java.lang.ArithmeticException": supervised.resume(); break;
//            case "java.lang.IllegalArgumentException": supervised.stop(supervisionStrategy().scope()); break;
//            default: supervised.escalate(); break;
//        }

        }

        @Override
        public SupervisionStrategy supervisionStrategy () {
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
        public Supervisor supervisor () {
            return this;
        }
    }
