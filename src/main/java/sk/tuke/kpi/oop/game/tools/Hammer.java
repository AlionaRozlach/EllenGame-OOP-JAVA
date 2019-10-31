package sk.tuke.kpi.oop.game.tools;

import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.Reactor;

public class Hammer extends BreakableTool<Reactor>{

    //private int pocet = 1;
    private Animation kladivo;
    private Reactor reactor;

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

    @Override
    public void useWith(Reactor reactor)
    {
        if(reactor != null)
        {
            if(reactor.getDamage()<100 && reactor.getDamage()!=0)//
            {
                if(reactor.repair() == true)
                {
                     super.useWith(this.reactor);
                }
            }
        }
        else return;
    }

    public int getRemainingUses()
    {
        return get();
    }
}
