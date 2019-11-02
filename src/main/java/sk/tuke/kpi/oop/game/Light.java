package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Light extends AbstractActor implements Switchable, EnergyConsumer {

    private Animation light_on;
    private Animation light_off;
    private boolean electric = false;
    //private boolean prepinac ;
    private boolean state = false;
    //rivate Reactor reactor;

    public Light()
    {

        light_on = new Animation("sprites/light_on.png",16,16);
        light_off = new Animation ("sprites/light_off.png",16,16);
        setAnimation(light_off);
    }


    public void uupdateAnimation()
    {
        if(electric==true && state == true) {
            setAnimation(light_on);
        }
            else setAnimation(light_off);
    }

    public void toggle()
    {
            if(state==false)//this.prepinac == true
            {
                state = true;
                uupdateAnimation();
            }
            else
            {
                state = false;
                uupdateAnimation();
            }
    }


    public void setElectricityFlow(boolean electric)
    {
        this.electric = electric;
        if(this.electric == true)
        {
            if(this.state == true)
            {
                state = true;
                setAnimation(light_on);
            }
            else
            {
                state = false;
                setAnimation(light_off);}
        }
        else {
            state = false;
            setAnimation(light_off);
        }
    }

    @Override
    public void turnOn() {
        state = true;
        if(electric == true && state==true) {
            setAnimation(light_on);
        }
        else setAnimation(light_off);
    }

    @Override
    public void turnOff() {
           state = false;
           setAnimation(light_off);
    }

    @Override
    public boolean isOn()
    {
        if(electric == true)
        {
            if(state == true)
            {
                return true;
            }
            else return false;
        }
        else return false;
    }

    @Override
    public void setPowered(boolean power) {
        this.electric = power;
        if(electric == true && state == true)
        {
            setAnimation(light_on);
        }
        else setAnimation(light_on);
    }
}
