package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.characters.Ripley;
import sk.tuke.kpi.oop.game.items.Hammer;
import sk.tuke.kpi.oop.game.items.Usable;

public class Locker extends AbstractActor implements Usable<Ripley> {

    public Locker()
    {
        Animation locked;
        locked = new Animation("sprites/locker.png",16,16);
        setAnimation(locked);
    }


    @Override
    public void useWith(Ripley actor) {
        Scene scene = getScene();
        if(scene!=null && actor.intersects(this))
        {
            int x = this.getPosX();
            int y = getPosY();
            scene.addActor(new Hammer(),x,y);
            scene.removeActor(this);
        }
    }

    @Override
    public Class<Ripley> getUsingActorClass() {
        return Ripley.class;
    }
}
