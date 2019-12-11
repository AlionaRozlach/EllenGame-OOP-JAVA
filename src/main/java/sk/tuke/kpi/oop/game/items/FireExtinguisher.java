package sk.tuke.kpi.oop.game.items;


import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.Reactor;

public class FireExtinguisher extends BreakableTool<Reactor> implements Collectible{
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

    @Override
     public void useWith(Reactor fire)
    {
        if(fire !=null && fire.extinguish() == true) {
            super.useWith(fire);
        }
    }
}
