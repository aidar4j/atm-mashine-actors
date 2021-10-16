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
import playground.Atm;
import playground.CardReader;
import playground.Bank;

public class Atm__Proxy extends ActorProxyBase<playground.Atm> implements playground.Atm, Proxy {

  private static final String verifyPinRepresentation1 = "verifyPin(playground.Bank)";
  private static final String insertCardRepresentation2 = "insertCard(playground.CardReader)";
  private static final String declinePinRepresentation3 = "declinePin()";
  private static final String receiveCardRepresentation4 = "receiveCard(playground.CardReader)";
  private static final String acceptPinRepresentation5 = "acceptPin()";
  private static final String stopRepresentation6 = "stop()";
  private static final String isStoppedRepresentation7 = "isStopped()";
  private static final String concludeRepresentation8 = "conclude()";

  private final Actor actor;
  private final Mailbox mailbox;

  public Atm__Proxy(final Actor actor, final Mailbox mailbox) {
    super(playground.Atm.class, SerializationProxy.from(actor.definition()), actor.address());
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


  public void verifyPin(playground.Bank arg0) {
    if (!actor.isStopped()) {
      ActorProxyBase<Atm> self = this;
      final SerializableConsumer<Atm> consumer = (actor) -> actor.verifyPin(ActorProxyBase.thunk(self, (Actor)actor, arg0));
      if (mailbox.isPreallocated()) { mailbox.send(actor, Atm.class, consumer, null, verifyPinRepresentation1); }
      else { mailbox.send(new LocalMessage<Atm>(actor, Atm.class, consumer, verifyPinRepresentation1)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, verifyPinRepresentation1));
    }
  }

  public void insertCard(playground.CardReader arg0) {
    if (!actor.isStopped()) {
      ActorProxyBase<Atm> self = this;
      final SerializableConsumer<Atm> consumer = (actor) -> actor.insertCard(ActorProxyBase.thunk(self, (Actor)actor, arg0));
      if (mailbox.isPreallocated()) { mailbox.send(actor, Atm.class, consumer, null, insertCardRepresentation2); }
      else { mailbox.send(new LocalMessage<Atm>(actor, Atm.class, consumer, insertCardRepresentation2)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, insertCardRepresentation2));
    }
  }

  public void declinePin() {
    if (!actor.isStopped()) {
      ActorProxyBase<Atm> self = this;
      final SerializableConsumer<Atm> consumer = (actor) -> actor.declinePin();
      if (mailbox.isPreallocated()) { mailbox.send(actor, Atm.class, consumer, null, declinePinRepresentation3); }
      else { mailbox.send(new LocalMessage<Atm>(actor, Atm.class, consumer, declinePinRepresentation3)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, declinePinRepresentation3));
    }
  }

  public void receiveCard(playground.CardReader arg0) {
    if (!actor.isStopped()) {
      ActorProxyBase<Atm> self = this;
      final SerializableConsumer<Atm> consumer = (actor) -> actor.receiveCard(ActorProxyBase.thunk(self, (Actor)actor, arg0));
      if (mailbox.isPreallocated()) { mailbox.send(actor, Atm.class, consumer, null, receiveCardRepresentation4); }
      else { mailbox.send(new LocalMessage<Atm>(actor, Atm.class, consumer, receiveCardRepresentation4)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, receiveCardRepresentation4));
    }
  }

  public void acceptPin() {
    if (!actor.isStopped()) {
      ActorProxyBase<Atm> self = this;
      final SerializableConsumer<Atm> consumer = (actor) -> actor.acceptPin();
      if (mailbox.isPreallocated()) { mailbox.send(actor, Atm.class, consumer, null, acceptPinRepresentation5); }
      else { mailbox.send(new LocalMessage<Atm>(actor, Atm.class, consumer, acceptPinRepresentation5)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, acceptPinRepresentation5));
    }
  }

  public void stop() {
    if (!actor.isStopped()) {
      ActorProxyBase<Atm> self = this;
      final SerializableConsumer<Atm> consumer = (actor) -> actor.stop();
      if (mailbox.isPreallocated()) { mailbox.send(actor, Atm.class, consumer, null, stopRepresentation6); }
      else { mailbox.send(new LocalMessage<Atm>(actor, Atm.class, consumer, stopRepresentation6)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, stopRepresentation6));
    }
  }

  public boolean isStopped() {
    if (!actor.isStopped()) {
      ActorProxyBase<Atm> self = this;
      final SerializableConsumer<Atm> consumer = (actor) -> actor.isStopped();
      if (mailbox.isPreallocated()) { mailbox.send(actor, Atm.class, consumer, null, isStoppedRepresentation7); }
      else { mailbox.send(new LocalMessage<Atm>(actor, Atm.class, consumer, isStoppedRepresentation7)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, isStoppedRepresentation7));
    }
    return false;
  }

  public void conclude() {
    if (!actor.isStopped()) {
      ActorProxyBase<Atm> self = this;
      final SerializableConsumer<Atm> consumer = (actor) -> actor.conclude();
      if (mailbox.isPreallocated()) { mailbox.send(actor, Atm.class, consumer, null, concludeRepresentation8); }
      else { mailbox.send(new LocalMessage<Atm>(actor, Atm.class, consumer, concludeRepresentation8)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, concludeRepresentation8));
    }
  }
}
