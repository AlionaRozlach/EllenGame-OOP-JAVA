package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.framework.actions.Loop;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Cooler extends AbstractActor implements Switchable {
    private Animation cooler;
    private boolean state;
    Reactor reactor;
    public Cooler(Reactor reactor)
    {
        this.reactor = reactor;
        cooler = new Animation("sprites/fan.png",32,32,0.2f);
        cooler.stop();
        setAnimation(cooler);

    }

   public void update_animation(boolean state)
    {
        if(state == false)
        {
            cooler.play();
        }
        else
        {
            cooler.stop();
        }
    }

    @Override
    public void turnOn()
    {
        if(this.state == false)
        {
            this.state  = true;
            update_animation(false);
        }
        else return;
    }

    @Override
    public void turnOff()
    {
        if(this.state == true)
        {
            this.state = false;
            update_animation(true);
        }
        else return;
    }

    @Override
    public boolean isOn()
    {
        if(this.state == true) return true;
        else return false;
    }

    private void coolReactor()
    {
        if(reactor != null && state == true)
        {
           int dec = 1;
           reactor.decreaseTemperature(1);
        }
        return;

    }

    @Override
    public void addedToScene(Scene scene)
    {
        if(scene == null) return;
        super.addedToScene(scene);
        if(reactor != null) {
            new Loop<>(new Invoke<>(this::coolReactor)).scheduleFor(this);
        }
    }
}
