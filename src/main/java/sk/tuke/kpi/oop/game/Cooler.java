package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.framework.actions.Loop;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Cooler extends AbstractActor implements Switchable {
    private Animation anim;
    private boolean state;
    private Reactor reactor;

    public Cooler(Reactor reactor)
    {
        this.reactor = reactor;
        anim = new Animation("sprites/fan.png",32,32,0.2f);
        anim.stop();
        setAnimation(anim);

    }

    public Reactor getReactor()
    {
        return this.reactor;
    }

   public void updateAnimation(boolean state)
    {
        if(state == false)
        {
            anim.play();
        }
        else
        {
            anim.stop();
        }
    }

    @Override
    public void turnOn()
    {
        if(this.state == false)
        {
            this.state  = true;
            updateAnimation(false);
        }
    }

    @Override
    public void turnOff()
    {
        if(this.state == true)
        {
            this.state = false;
            updateAnimation(true);
        }
    }

    @Override
    public boolean isOn()
    {
        if(this.state == true) return true;
        else return false;
    }

    @Override
    public void toggle() {
        if(isOn())turnOff();
        else turnOn();
    }

    private void coolReactor()
    {
        if(reactor != null && state == true)
        {
           int dec = 1;
           reactor.decreaseTemperature(dec);
        }
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
