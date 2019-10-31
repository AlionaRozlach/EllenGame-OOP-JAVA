package sk.tuke.kpi.oop.game.tools;

import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.Reactor;

public class Hammer extends BreakableTool<Reactor>{

    //private int pocet = 1;
    private Animation kladivo;

    public Hammer ()
    {
        super(1);
        //this.pocet = pocet;
        kladivo = new Animation("sprites/hammer.png");
        setAnimation(kladivo);
    }

    public Hammer (int pocet)
    {
        //this.pocet = pocet;
        super(pocet);
    }

   /* @Override
    public void useWith(Reactor reactor)
    {
        if(reactor != null )
        {
           if(reactor.repair())
           {
               super.useWith(this.rea);
           }
        }
    }*/
}
