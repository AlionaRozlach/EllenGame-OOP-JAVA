package sk.tuke.kpi.oop.game.tools;

import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.Reactor;

public class FireExtinguisher extends BreakableTool<Reactor> {
   // private int pocet;


    public FireExtinguisher()
    {
        super(1);
        Animation extiguisher;
        extiguisher  = new Animation("sprites/extinguisher.png");
        setAnimation(extiguisher);

    }

    public int getRemainingUses()
    {
        return get();
    }
}
