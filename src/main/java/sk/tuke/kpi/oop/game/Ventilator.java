package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Ventilator extends AbstractActor implements Repairable {

    private Animation ventik;
    private boolean state;
   public Ventilator()
   {
       ventik = new Animation("sprites/ventilator.png",32,32,0.1f);
       setAnimation(ventik);
       ventik.stop();
   }

    @Override
    public boolean repair() {
        if (ventik != null) {
            ventik.play();
            state = true;
            return state;
        }
        state = false;
        return state;
    }
}

