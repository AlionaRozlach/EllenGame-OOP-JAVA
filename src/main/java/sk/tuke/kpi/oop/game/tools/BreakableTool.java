package sk.tuke.kpi.oop.game.tools;

import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.oop.game.Reactor;

public class BreakableTool< Acter extends Actor> extends AbstractActor implements Usable<Acter>{

    private int remainingUses;

    public BreakableTool(int pocet)
    {
        this.remainingUses = pocet;
    }

    @Override
    public void useWith(Acter actor)
    {
        if(this.remainingUses>0) this.remainingUses--;
        if(this.remainingUses == 0)
        {
            Scene scene =getScene();
            scene.removeActor(this);
        }
    }

    public int get()
    {
        return this.remainingUses;
    }


}
