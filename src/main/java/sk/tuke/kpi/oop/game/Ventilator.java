package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.gamelib.messages.Topic;

public class Ventilator extends AbstractActor implements Repairable {

    private Animation ventik;
    private boolean state;

    public static final Topic<Ventilator> VENTILATOR_REPAIRED = Topic.create("VENTILATOR_REPAIRED", Ventilator.class);
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
            Scene scene = getScene();
            scene.getMessageBus().publish(Ventilator.VENTILATOR_REPAIRED, this);
            return state;
        }
        state = false;
        return state;
    }
}

