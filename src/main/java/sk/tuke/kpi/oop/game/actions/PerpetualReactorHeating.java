package sk.tuke.kpi.oop.game.actions;
import sk.tuke.kpi.oop.game.Reactor;
import sk.tuke.kpi.gamelib.framework.actions.AbstractAction;


public class PerpetualReactorHeating extends AbstractAction<Reactor>{

    private  int increment;
    public PerpetualReactorHeating(int increment)
    {
        this.increment = increment;
    }
    @Override
    public void execute(float deltaTime)
    {
        System.out.println("рраыпы");
        Reactor actual = getActor();
        if(actual == null) return;
        actual.increaseTemperature(increment);
    }


}


