package ;

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
import Atm;
import CardReader;

public class Atm__Proxy extends ActorProxyBase<Atm> implements Atm, Proxy {

  private static final String receiveCardRepresentation1 = "receiveCard()";
  private static final String ejectCardRepresentation2 = "ejectCard(CardReader)";
  private static final String stopRepresentation3 = "stop()";
  private static final String isStoppedRepresentation4 = "isStopped()";
  private static final String concludeRepresentation5 = "conclude()";

  private final Actor actor;
  private final Mailbox mailbox;

  public Atm__Proxy(final Actor actor, final Mailbox mailbox) {
    super(Atm.class, SerializationProxy.from(actor.definition()), actor.address());
    this.actor = actor;
    this.mailbox = mailbox;
  }

  public Atm__Proxy() {
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
    return "Atm[address=" + actor.address() + "]";
  }


  public void receiveCard() {
    if (!actor.isStopped()) {
      ActorProxyBase<Atm> self = this;
      final SerializableConsumer<Atm> consumer = (actor) -> actor.receiveCard();
      if (mailbox.isPreallocated()) { mailbox.send(actor, Atm.class, consumer, null, receiveCardRepresentation1); }
      else { mailbox.send(new LocalMessage<Atm>(actor, Atm.class, consumer, receiveCardRepresentation1)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, receiveCardRepresentation1));
    }
  }

  public void ejectCard(CardReader arg0) {
    if (!actor.isStopped()) {
      ActorProxyBase<Atm> self = this;
      final SerializableConsumer<Atm> consumer = (actor) -> actor.ejectCard(ActorProxyBase.thunk(self, (Actor)actor, arg0));
      if (mailbox.isPreallocated()) { mailbox.send(actor, Atm.class, consumer, null, ejectCardRepresentation2); }
      else { mailbox.send(new LocalMessage<Atm>(actor, Atm.class, consumer, ejectCardRepresentation2)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, ejectCardRepresentation2));
    }
  }

  public void stop() {
    if (!actor.isStopped()) {
      ActorProxyBase<Atm> self = this;
      final SerializableConsumer<Atm> consumer = (actor) -> actor.stop();
      if (mailbox.isPreallocated()) { mailbox.send(actor, Atm.class, consumer, null, stopRepresentation3); }
      else { mailbox.send(new LocalMessage<Atm>(actor, Atm.class, consumer, stopRepresentation3)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, stopRepresentation3));
    }
  }

  public boolean isStopped() {
    if (!actor.isStopped()) {
      ActorProxyBase<Atm> self = this;
      final SerializableConsumer<Atm> consumer = (actor) -> actor.isStopped();
      if (mailbox.isPreallocated()) { mailbox.send(actor, Atm.class, consumer, null, isStoppedRepresentation4); }
      else { mailbox.send(new LocalMessage<Atm>(actor, Atm.class, consumer, isStoppedRepresentation4)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, isStoppedRepresentation4));
    }
    return false;
  }

  public void conclude() {
    if (!actor.isStopped()) {
      ActorProxyBase<Atm> self = this;
      final SerializableConsumer<Atm> consumer = (actor) -> actor.conclude();
      if (mailbox.isPreallocated()) { mailbox.send(actor, Atm.class, consumer, null, concludeRepresentation5); }
      else { mailbox.send(new LocalMessage<Atm>(actor, Atm.class, consumer, concludeRepresentation5)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, concludeRepresentation5));
    }
  }
}
