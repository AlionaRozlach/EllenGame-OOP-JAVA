package sk.tuke.kpi.oop.game.tools;

import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.DefectiveLight;
import sk.tuke.kpi.oop.game.Reactor;

public class Wrench extends BreakableTool<DefectiveLight> {

    private Animation wrench;
    public Wrench()
    {
        super(2);
        wrench = new Animation("sprites/ wrench.png");
        setAnimation(wrench);
    }

    @Override
    public void useWith(DefectiveLight defectiveLight) {
        super.useWith(defectiveLight);
    }
}
