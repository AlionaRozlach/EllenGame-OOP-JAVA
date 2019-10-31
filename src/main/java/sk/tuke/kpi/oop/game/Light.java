package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Light extends AbstractActor implements Switchable, EnergyConsumer {

    private Animation light_on;
    private Animation light_off;
    private boolean electric;
    private boolean prepinac;
    private boolean state;

    public Light()
    {
        light_on = new Animation("sprites/light_on.png",16,16);
        light_off = new Animation ("sprites/light_off.png",16,16);
        if(electric == false )
        {
            setAnimation(light_off);
        }
        if(electric == true ) setAnimation(light_on);
    }

    public void toggle()
    {
        if(this.electric == true)
        {
            if(state==true)//this.prepinac == true
            {
                state = false;
                this.prepinac = false;
                setAnimation(light_off);
            }
            else
            {
                state = true;
                this.prepinac = true;
                setAnimation(light_on);
            }
        }
        else
        {
            state = false;
            setAnimation(light_off);
        }
    }

    public void setElectricityFlow(boolean electric)
    {
        this.electric = electric;
        if(this.electric == true)
        {
            if(this.prepinac == true)
            {
                setAnimation(light_on);
            }
            else setAnimation(light_off);
        }
        else setAnimation(light_off);
    }

    public void updateAnimation(boolean prepinac)
    {
        if(prepinac == true) setAnimation(light_off);
        else setAnimation(light_on);
    }

    @Override
    public void turnOn() {
        if(electric == true && prepinac == false)
        {
                state = true;
                prepinac = true;
                setAnimation(light_on);
        }
    }

    @Override
    public void turnOff() {
        if(electric == true && prepinac == true)
        {
            state = false;
            prepinac = false;
                setAnimation(light_off);
        }
    }

    @Override
    public boolean isOn()
    {
        if(electric == true)
        {
            if(prepinac == true)
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
    }
}
