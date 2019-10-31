package sk.tuke.kpi.oop.game.tools;

import sk.tuke.kpi.gamelib.graphics.Animation;

public class Mjolnir extends Hammer {

    private Animation molot;


    public Mjolnir()
    {
        super(4);
       molot = new Animation("sprites/hammer.png");
        setAnimation(molot);
    }

    public int getRemainingUses()
    {
        return this.get();
    }
}
