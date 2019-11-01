package sk.tuke.kpi.oop.game.tools;

import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.Reactor;

public class Hammer extends BreakableTool<Reactor>{

    //private int pocet = 1;


    public Hammer ()
    {
        super(1);
        Animation kladivo;
        kladivo = new Animation("sprites/hammer.png");
        setAnimation(kladivo);
    }

    public Hammer (int pocet)
    {
        //this.pocet = pocet;
        super(pocet);
    }

    @Override
    public void useWith(Reactor reactor)
    {
        if(reactor != null && reactor.repair() == true)
        {
            super.useWith(reactor);
        }
    }

    public int getRemainingUses()
    {
        return get();
    }


}
