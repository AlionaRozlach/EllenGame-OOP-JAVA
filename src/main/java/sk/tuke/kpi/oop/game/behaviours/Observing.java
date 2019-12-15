package sk.tuke.kpi.oop.game.behaviours;

import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.messages.Topic;

import java.util.function.Predicate;

public class Observing<A extends Actor, T> implements Behaviour<A> {

    private Predicate<T> predicate;
    private Behaviour<A> delegate;
    private Topic<T> topic;



    public Observing( Predicate<T> predicate,Behaviour<A> delegate,Topic<T> topic) {
        this.topic = topic;
        this.predicate = predicate;
        this.delegate = delegate;
    }

    @Override
    public void setUp(A actor) {
        if (actor == null) {
            return;
        }
        cyklusDekorate(actor);
    }
    private void cyklusDekorate(A actor)
    {
        actor.getScene().getMessageBus().subscribe(this.topic, k -> {
            if (predicate.test(k)){
                delegate.setUp(actor);
            }
        });
    }
}
