package sk.tuke.kpi.oop.game.tools;

import sk.tuke.kpi.gamelib.graphics.Animation;

public class Mjolnir extends Hammer {


    private Animation molot;
    public int pocet;

    public Mjolnir()
    {
        super(4);
        this.molot = new Animation("sprites/hammer.png");
        setAnimation(this.molot);
    }

}
