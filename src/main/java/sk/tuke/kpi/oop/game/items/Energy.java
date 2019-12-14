package sk.tuke.kpi.oop.game.items;


import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.characters.Alive;
import sk.tuke.kpi.oop.game.characters.Ripley;


public class Energy extends AbstractActor implements Usable<Alive> {

    public Energy() {
        Animation energetic;
        energetic = new Animation("sprites/energy.png", 16, 16);
        setAnimation(energetic);
    }

    @Override
    public void useWith(Alive actor) {
        if ((this.getScene() != null) && (actor != null)) {
            actor.getHealth().refill(50);
            this.getScene().removeActor(this);
        }
    }


    public Class<Alive> getUsingActorClass() {
        return Alive.class;
    }
}
