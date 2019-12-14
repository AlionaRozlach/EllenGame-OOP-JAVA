package sk.tuke.kpi.oop.game.items;

import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.Repairable;

public class Hammer extends BreakableTool<Repairable>{

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
    public void useWith(Repairable repairable)
    {
        if(repairable != null && repairable.repair() == true)
        {
            super.useWith(repairable);
        }
    }

    public int getRemainingUses()
    {
        return get();
    }

    public Class<Repairable> getUsingActorClass() {
        return Repairable.class;
    }
}
