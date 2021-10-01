package greaterExample;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.typed.ActorSystem;

import java.io.IOException;
public class AkkaQuickstart extends AbstractActor {
    public static void main(String[] args) {
        //#actor-system
        final ActorSystem<GreeterMain.SayHello> greeterMain = ActorSystem.create(GreeterMain.create(), "helloakka");
        //#actor-system

        //#main-send-messages
        greeterMain.tell(new GreeterMain.SayHello("Charles"));
        //#main-send-messages


        //ActorRef atm = getContext().actorOf(ATM.props());

        try {
            System.out.println(">>> Press ENTER to exit <<<");
            System.in.read();
        } catch (IOException ignored) {
        } finally {
            greeterMain.terminate();
        }
    }

    @Override
    public Receive createReceive() {
        return null;
    }
}