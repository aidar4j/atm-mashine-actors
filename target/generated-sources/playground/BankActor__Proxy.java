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
import playground.BankActor;
import io.vlingo.xoom.actors.DeadLetters;
import io.vlingo.xoom.actors.Definition;
import java.lang.Class;
import java.lang.Object;
import playground.Atm;
import io.vlingo.xoom.common.Scheduler;
import io.vlingo.xoom.actors.Address;
import io.vlingo.xoom.actors.testkit.TestContext;
import io.vlingo.xoom.actors.testkit.TestState;
import java.lang.String;

public class BankActor__Proxy extends ActorProxyBase<playground.BankActor> implements playground.BankActor, Proxy {

  private static final String checkPinRepresentation1 = "checkPin(playground.Atm)";
  private static final String equalsRepresentation2 = "equals(java.lang.Object)";
  private static final String toStringRepresentation3 = "toString()";
  private static final String hashCodeRepresentation4 = "hashCode()";
  private static final String startRepresentation5 = "start()";
  private static final String stopRepresentation6 = "stop()";
  private static final String addressRepresentation7 = "address()";
  private static final String isStoppedRepresentation8 = "isStopped()";
  private static final String schedulerRepresentation9 = "scheduler()";
  private static final String viewTestStateInitializationRepresentation10 = "viewTestStateInitialization(io.vlingo.xoom.actors.testkit.TestContext)";
  private static final String stateSnapshotRepresentation11 = "stateSnapshot()";
  private static final String stateSnapshotRepresentation12 = "stateSnapshot(S)";
  private static final String viewTestStateRepresentation13 = "viewTestState()";
  private static final String concludeRepresentation14 = "conclude()";
  private static final String deadLettersRepresentation15 = "deadLetters()";
  private static final String definitionRepresentation16 = "definition()";
  private static final String waitRepresentation17 = "wait(long)";
  private static final String waitRepresentation18 = "wait(long, int)";
  private static final String waitRepresentation19 = "wait()";
  private static final String getClassRepresentation20 = "getClass()";
  private static final String notifyRepresentation21 = "notify()";
  private static final String notifyAllRepresentation22 = "notifyAll()";

  private final Actor actor;
  private final Mailbox mailbox;

  public BankActor__Proxy(final Actor actor, final Mailbox mailbox) {
    super(playground.BankActor.class, SerializationProxy.from(actor.definition()), actor.address());
    this.actor = actor;
    this.mailbox = mailbox;
  }

  public BankActor__Proxy() {
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
    return "BankActor[address=" + actor.address() + "]";
  }


  public void checkPin(playground.Atm arg0) {
    if (!actor.isStopped()) {
      ActorProxyBase<BankActor> self = this;
      final SerializableConsumer<BankActor> consumer = (actor) -> actor.checkPin(ActorProxyBase.thunk(self, (Actor)actor, arg0));
      if (mailbox.isPreallocated()) { mailbox.send(actor, BankActor.class, consumer, null, checkPinRepresentation1); }
      else { mailbox.send(new LocalMessage<BankActor>(actor, BankActor.class, consumer, checkPinRepresentation1)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, checkPinRepresentation1));
    }
  }

  public boolean equals(java.lang.Object arg0) {
    if (!actor.isStopped()) {
      ActorProxyBase<BankActor> self = this;
      final SerializableConsumer<BankActor> consumer = (actor) -> actor.equals(ActorProxyBase.thunk(self, (Actor)actor, arg0));
      if (mailbox.isPreallocated()) { mailbox.send(actor, BankActor.class, consumer, null, equalsRepresentation2); }
      else { mailbox.send(new LocalMessage<BankActor>(actor, BankActor.class, consumer, equalsRepresentation2)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, equalsRepresentation2));
    }
    return false;
  }

  public java.lang.String toString() {
    if (!actor.isStopped()) {
      ActorProxyBase<BankActor> self = this;
      final SerializableConsumer<BankActor> consumer = (actor) -> actor.toString();
      if (mailbox.isPreallocated()) { mailbox.send(actor, BankActor.class, consumer, null, toStringRepresentation3); }
      else { mailbox.send(new LocalMessage<BankActor>(actor, BankActor.class, consumer, toStringRepresentation3)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, toStringRepresentation3));
    }
    return null;
  }

  public int hashCode() {
    if (!actor.isStopped()) {
      ActorProxyBase<BankActor> self = this;
      final SerializableConsumer<BankActor> consumer = (actor) -> actor.hashCode();
      if (mailbox.isPreallocated()) { mailbox.send(actor, BankActor.class, consumer, null, hashCodeRepresentation4); }
      else { mailbox.send(new LocalMessage<BankActor>(actor, BankActor.class, consumer, hashCodeRepresentation4)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, hashCodeRepresentation4));
    }
    return 0;
  }

  public void start() {
    if (!actor.isStopped()) {
      ActorProxyBase<BankActor> self = this;
      final SerializableConsumer<BankActor> consumer = (actor) -> actor.start();
      if (mailbox.isPreallocated()) { mailbox.send(actor, BankActor.class, consumer, null, startRepresentation5); }
      else { mailbox.send(new LocalMessage<BankActor>(actor, BankActor.class, consumer, startRepresentation5)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, startRepresentation5));
    }
  }

  public void stop() {
    if (!actor.isStopped()) {
      ActorProxyBase<BankActor> self = this;
      final SerializableConsumer<BankActor> consumer = (actor) -> actor.stop();
      if (mailbox.isPreallocated()) { mailbox.send(actor, BankActor.class, consumer, null, stopRepresentation6); }
      else { mailbox.send(new LocalMessage<BankActor>(actor, BankActor.class, consumer, stopRepresentation6)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, stopRepresentation6));
    }
  }

  public io.vlingo.xoom.actors.Address address() {
    if (!actor.isStopped()) {
      ActorProxyBase<BankActor> self = this;
      final SerializableConsumer<BankActor> consumer = (actor) -> actor.address();
      if (mailbox.isPreallocated()) { mailbox.send(actor, BankActor.class, consumer, null, addressRepresentation7); }
      else { mailbox.send(new LocalMessage<BankActor>(actor, BankActor.class, consumer, addressRepresentation7)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, addressRepresentation7));
    }
    return null;
  }

  public boolean isStopped() {
    if (!actor.isStopped()) {
      ActorProxyBase<BankActor> self = this;
      final SerializableConsumer<BankActor> consumer = (actor) -> actor.isStopped();
      if (mailbox.isPreallocated()) { mailbox.send(actor, BankActor.class, consumer, null, isStoppedRepresentation8); }
      else { mailbox.send(new LocalMessage<BankActor>(actor, BankActor.class, consumer, isStoppedRepresentation8)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, isStoppedRepresentation8));
    }
    return false;
  }

  public io.vlingo.xoom.common.Scheduler scheduler() {
    if (!actor.isStopped()) {
      ActorProxyBase<BankActor> self = this;
      final SerializableConsumer<BankActor> consumer = (actor) -> actor.scheduler();
      if (mailbox.isPreallocated()) { mailbox.send(actor, BankActor.class, consumer, null, schedulerRepresentation9); }
      else { mailbox.send(new LocalMessage<BankActor>(actor, BankActor.class, consumer, schedulerRepresentation9)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, schedulerRepresentation9));
    }
    return null;
  }

  public void viewTestStateInitialization(io.vlingo.xoom.actors.testkit.TestContext arg0) {
    if (!actor.isStopped()) {
      ActorProxyBase<BankActor> self = this;
      final SerializableConsumer<BankActor> consumer = (actor) -> actor.viewTestStateInitialization(ActorProxyBase.thunk(self, (Actor)actor, arg0));
      if (mailbox.isPreallocated()) { mailbox.send(actor, BankActor.class, consumer, null, viewTestStateInitializationRepresentation10); }
      else { mailbox.send(new LocalMessage<BankActor>(actor, BankActor.class, consumer, viewTestStateInitializationRepresentation10)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, viewTestStateInitializationRepresentation10));
    }
  }

  public <S>S stateSnapshot() {
    if (!actor.isStopped()) {
      ActorProxyBase<BankActor> self = this;
      final SerializableConsumer<BankActor> consumer = (actor) -> actor.stateSnapshot();
      if (mailbox.isPreallocated()) { mailbox.send(actor, BankActor.class, consumer, null, stateSnapshotRepresentation11); }
      else { mailbox.send(new LocalMessage<BankActor>(actor, BankActor.class, consumer, stateSnapshotRepresentation11)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, stateSnapshotRepresentation11));
    }
    return null;
  }

  public <S>void stateSnapshot(S arg0) {
    if (!actor.isStopped()) {
      ActorProxyBase<BankActor> self = this;
      final SerializableConsumer<BankActor> consumer = (actor) -> actor.stateSnapshot(ActorProxyBase.thunk(self, (Actor)actor, arg0));
      if (mailbox.isPreallocated()) { mailbox.send(actor, BankActor.class, consumer, null, stateSnapshotRepresentation12); }
      else { mailbox.send(new LocalMessage<BankActor>(actor, BankActor.class, consumer, stateSnapshotRepresentation12)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, stateSnapshotRepresentation12));
    }
  }

  public io.vlingo.xoom.actors.testkit.TestState viewTestState() {
    if (!actor.isStopped()) {
      ActorProxyBase<BankActor> self = this;
      final SerializableConsumer<BankActor> consumer = (actor) -> actor.viewTestState();
      if (mailbox.isPreallocated()) { mailbox.send(actor, BankActor.class, consumer, null, viewTestStateRepresentation13); }
      else { mailbox.send(new LocalMessage<BankActor>(actor, BankActor.class, consumer, viewTestStateRepresentation13)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, viewTestStateRepresentation13));
    }
    return null;
  }

  public void conclude() {
    if (!actor.isStopped()) {
      ActorProxyBase<BankActor> self = this;
      final SerializableConsumer<BankActor> consumer = (actor) -> actor.conclude();
      if (mailbox.isPreallocated()) { mailbox.send(actor, BankActor.class, consumer, null, concludeRepresentation14); }
      else { mailbox.send(new LocalMessage<BankActor>(actor, BankActor.class, consumer, concludeRepresentation14)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, concludeRepresentation14));
    }
  }

  public io.vlingo.xoom.actors.DeadLetters deadLetters() {
    if (!actor.isStopped()) {
      ActorProxyBase<BankActor> self = this;
      final SerializableConsumer<BankActor> consumer = (actor) -> actor.deadLetters();
      if (mailbox.isPreallocated()) { mailbox.send(actor, BankActor.class, consumer, null, deadLettersRepresentation15); }
      else { mailbox.send(new LocalMessage<BankActor>(actor, BankActor.class, consumer, deadLettersRepresentation15)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, deadLettersRepresentation15));
    }
    return null;
  }

  public io.vlingo.xoom.actors.Definition definition() {
    if (!actor.isStopped()) {
      ActorProxyBase<BankActor> self = this;
      final SerializableConsumer<BankActor> consumer = (actor) -> actor.definition();
      if (mailbox.isPreallocated()) { mailbox.send(actor, BankActor.class, consumer, null, definitionRepresentation16); }
      else { mailbox.send(new LocalMessage<BankActor>(actor, BankActor.class, consumer, definitionRepresentation16)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, definitionRepresentation16));
    }
    return null;
  }

  public void wait(long arg0) throws java.lang.InterruptedException {
    if (!actor.isStopped()) {
      ActorProxyBase<BankActor> self = this;
      final SerializableConsumer<BankActor> consumer = (actor) -> actor.wait(ActorProxyBase.thunk(self, (Actor)actor, arg0));
      if (mailbox.isPreallocated()) { mailbox.send(actor, BankActor.class, consumer, null, waitRepresentation17); }
      else { mailbox.send(new LocalMessage<BankActor>(actor, BankActor.class, consumer, waitRepresentation17)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, waitRepresentation17));
    }
  }

  public void wait(long arg0, int arg1) throws java.lang.InterruptedException {
    if (!actor.isStopped()) {
      ActorProxyBase<BankActor> self = this;
      final SerializableConsumer<BankActor> consumer = (actor) -> actor.wait(ActorProxyBase.thunk(self, (Actor)actor, arg0), ActorProxyBase.thunk(self, (Actor)actor, arg1));
      if (mailbox.isPreallocated()) { mailbox.send(actor, BankActor.class, consumer, null, waitRepresentation18); }
      else { mailbox.send(new LocalMessage<BankActor>(actor, BankActor.class, consumer, waitRepresentation18)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, waitRepresentation18));
    }
  }

  public void wait() throws java.lang.InterruptedException {
    if (!actor.isStopped()) {
      ActorProxyBase<BankActor> self = this;
      final SerializableConsumer<BankActor> consumer = (actor) -> actor.wait();
      if (mailbox.isPreallocated()) { mailbox.send(actor, BankActor.class, consumer, null, waitRepresentation19); }
      else { mailbox.send(new LocalMessage<BankActor>(actor, BankActor.class, consumer, waitRepresentation19)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, waitRepresentation19));
    }
  }

  public java.lang.Class<?> getClass() {
    if (!actor.isStopped()) {
      ActorProxyBase<BankActor> self = this;
      final SerializableConsumer<BankActor> consumer = (actor) -> actor.getClass();
      if (mailbox.isPreallocated()) { mailbox.send(actor, BankActor.class, consumer, null, getClassRepresentation20); }
      else { mailbox.send(new LocalMessage<BankActor>(actor, BankActor.class, consumer, getClassRepresentation20)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, getClassRepresentation20));
    }
    return null;
  }

  public void notify() {
    if (!actor.isStopped()) {
      ActorProxyBase<BankActor> self = this;
      final SerializableConsumer<BankActor> consumer = (actor) -> actor.notify();
      if (mailbox.isPreallocated()) { mailbox.send(actor, BankActor.class, consumer, null, notifyRepresentation21); }
      else { mailbox.send(new LocalMessage<BankActor>(actor, BankActor.class, consumer, notifyRepresentation21)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, notifyRepresentation21));
    }
  }

  public void notifyAll() {
    if (!actor.isStopped()) {
      ActorProxyBase<BankActor> self = this;
      final SerializableConsumer<BankActor> consumer = (actor) -> actor.notifyAll();
      if (mailbox.isPreallocated()) { mailbox.send(actor, BankActor.class, consumer, null, notifyAllRepresentation22); }
      else { mailbox.send(new LocalMessage<BankActor>(actor, BankActor.class, consumer, notifyAllRepresentation22)); }
    } else {
      actor.deadLetters().failedDelivery(new DeadLetter(actor, notifyAllRepresentation22));
    }
  }
}
