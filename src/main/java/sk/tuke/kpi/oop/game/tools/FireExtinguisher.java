package sk.tuke.kpi.oop.game.tools;

import sk.tuke.kpi.gamelib.graphics.Animation;

public class FireExtinguisher extends BreakableTool {
   // private int pocet;
    private Animation extiguisher;

    public FireExtinguisher()
    {
        super(1);
        this.extiguisher  = new Animation("sprites/extinguisher.png");
        setAnimation(extiguisher);

    }

}