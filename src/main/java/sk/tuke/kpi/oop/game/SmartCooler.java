package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.framework.actions.Loop;
import sk.tuke.kpi.oop.game.actions.PerpetualReactorHeating;

public class SmartCooler extends Cooler{

    Cooler coller;
   private boolean state = false;
    public SmartCooler(Reactor reactor) {
        super(reactor);
    }

    public void smartCooller()
    {
        if(reactor!=null)
        {
            if( reactor.getTemperature()>2500) {
                state = true;
                turnOn();
            }
            if(reactor.getTemperature()<=1500)
            {
                turnOff();
                state = false;
            }

            if(state == true)
            {
                turnOn();
                reactor.decreaseTemperature(2);
            }
            else turnOff();

        }
    }

    @Override

    public void addedToScene(Scene scene)
    {
        if(scene == null) return;
        super.addedToScene(scene);
        if(reactor != null) {
            new Loop<>(new Invoke<>(this::smartCooller)).scheduleFor(this);
        }
    }
}
