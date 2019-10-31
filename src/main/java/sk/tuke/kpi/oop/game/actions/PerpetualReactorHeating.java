package sk.tuke.kpi.oop.game.actions;

import sk.tuke.kpi.gamelib.Scene;
//import sk.tuke.kpi.inspector.annotations.Hide;
import sk.tuke.kpi.oop.game.Reactor;
import sk.tuke.kpi.gamelib.framework.actions.AbstractAction;
import sk.tuke.kpi.gamelib.framework.AbstractActor;

public class PerpetualReactorHeating extends AbstractAction<Reactor>{

    private  int increment;
    public PerpetualReactorHeating(int increment)
    {
        this.increment = increment;
    }
    @Override
    public void execute(float deltaTime)
    {
        Reactor actual = getActor();
        if(actual == null) return;
        actual.increaseTemperature(increment);
    }


}


