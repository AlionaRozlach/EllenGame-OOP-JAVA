package sk.tuke.kpi.oop.game.items;


import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.characters.Ripley;


public class Energy extends AbstractActor implements Usable<Ripley> {

    public Energy() {
        Animation energetic;
        energetic = new Animation("sprites/energy.png", 16, 16);
        setAnimation(energetic);
    }

    @Override
    public void useWith(Ripley actor) {
        if (actor.getEnergy() < 100) {
            actor.setEnergy(100);
            Scene scene = getScene();
            scene.removeActor(this);
        }
    }
}
