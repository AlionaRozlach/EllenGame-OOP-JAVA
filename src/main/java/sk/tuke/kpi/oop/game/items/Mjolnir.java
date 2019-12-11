package sk.tuke.kpi.oop.game.items;

import sk.tuke.kpi.gamelib.graphics.Animation;

public class Mjolnir extends Hammer {

    public Mjolnir()
    {
        super(4);
        Animation molot;
       molot = new Animation("sprites/hammer.png");
        setAnimation(molot);
    }
    public int getRemainingUses()
    {
        return get();
    }
}
