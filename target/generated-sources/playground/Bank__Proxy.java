package playground;

import io.vlingo.xoom.actors.Actor;
import io.vlingo.xoom.actors.ActorProxyBase;
import io.vlingo.xoom.actors.Address;
import io.vlingo.xoom.actors.DeadLetter;
import io.vlingo.xoom.actors.Definition.SerializationProxy;
import io.vlingo.xoom.actors.LocalMessage;
import io.vlingo.xoom.actors.Mailbox;
import io.vlingo.xoom.actors.Proxy;
import io.vlingo.xoom.actors.Returns;
import io.vlingo.xoom.common.Completes;
import io.vlingo.xoom.common.SerializableConsumer;
import playground.Bank;
import playground.Atm;

public class Bank__Proxy extends ActorProxyBase<playground.Bank> implements playground.Bank, Proxy {

  private static final String checkPinRepresentation1 = "checkPin(playground.Atm)";
  private static final String stopRepresentation2 = "stop()";
  private static final String isStoppedRepresentation3 = "isStopped()";
  private static final String concludeRepresentation4 = "conclude()";

  private final Actor actor;
  private final Mailbox mailbox;

  public Bank__Proxy(final Actor actor, final Mailbox mailbox) {
    super(playground.Bank.class, SerializationProxy.from(actor.definition()), actor.address());
    this.actor = actor;
    this.mailbox = mailbox;
  }

  public Bank__Proxy() {
    super();
    this.actor = null;
    this.mailbox = null;
  }


  public Address address() {
    return actor.address();
  }

  public boolean equals(final Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (other.getClass() != getClass()) return false;
    return address().equals(Proxy.from(other).address());
  }

  public int hashCode() {
    return 31 + getClass().hashCode() + actor.address().hashCode();
  }

  public String toString() {
    return "Bank[address=" + actor.address() + "]";
  }


  public void checkPin(playground.Atm arg0) {
    if (!actor.isStopped()) {
      ActorProxyBase<Bank> self = this;
      final SerializableConsumer<Bank> consumer = (actor) -> actor.checkPin(ActorProxyBase.thunk(self, (Actor)actor, arg0));
      if (mailbox.isPreallocated()) { mailbox.send(actor, Bank.class, consumer, null, checkPinRepresentation1); }
      else { mailbox.send(new LocalMessage<Bank>(actor, Bank.class, consumer, checkPinRepresentation1)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, checkPinRepresentation1));
    }
  }

  public void stop() {
    if (!actor.isStopped()) {
      ActorProxyBase<Bank> self = this;
      final SerializableConsumer<Bank> consumer = (actor) -> actor.stop();
      if (mailbox.isPreallocated()) { mailbox.send(actor, Bank.class, consumer, null, stopRepresentation2); }
      else { mailbox.send(new LocalMessage<Bank>(actor, Bank.class, consumer, stopRepresentation2)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, stopRepresentation2));
    }
  }

  public boolean isStopped() {
    if (!actor.isStopped()) {
      ActorProxyBase<Bank> self = this;
      final SerializableConsumer<Bank> consumer = (actor) -> actor.isStopped();
      if (mailbox.isPreallocated()) { mailbox.send(actor, Bank.class, consumer, null, isStoppedRepresentation3); }
      else { mailbox.send(new LocalMessage<Bank>(actor, Bank.class, consumer, isStoppedRepresentation3)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, isStoppedRepresentation3));
    }
    return false;
  }

  public void conclude() {
    if (!actor.isStopped()) {
      ActorProxyBase<Bank> self = this;
      final SerializableConsumer<Bank> consumer = (actor) -> actor.conclude();
      if (mailbox.isPreallocated()) { mailbox.send(actor, Bank.class, consumer, null, concludeRepresentation4); }
      else { mailbox.send(new LocalMessage<Bank>(actor, Bank.class, consumer, concludeRepresentation4)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, concludeRepresentation4));
    }
  }
}
