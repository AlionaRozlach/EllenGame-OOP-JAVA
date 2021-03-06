package sk.tuke.kpi.oop.game.items;

import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.DefectiveLight;


public class Wrench extends BreakableTool<DefectiveLight> implements Collectible{

    private Animation wrenchik;
    public Wrench()
    {
        super(2);
        wrenchik = new Animation("sprites/wrench.png");
        setAnimation(wrenchik);
    }

   @Override
    public void useWith(DefectiveLight defectiveLight)
    {
        super.useWith(defectiveLight);
    }

    public int getRemainingUses()
    {
        return get();
    }

    public Class<DefectiveLight> getUsingActorClass() {
        return DefectiveLight.class;
    }
}
