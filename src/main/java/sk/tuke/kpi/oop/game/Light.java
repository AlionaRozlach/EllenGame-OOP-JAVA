package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Light extends AbstractActor implements Switchable, EnergyConsumer {

    private Animation light_on;
    private Animation light_off;
    private boolean electric;
    //private boolean prepinac ;
    private boolean prepinac;
    //rivate Reactor reactor;

    public Light()
    {
        electric = false;
        prepinac = false;
        light_on = new Animation("sprites/light_on.png",16,16);
        light_off = new Animation ("sprites/light_off.png",16,16);
        setAnimation(light_off);
    }


    public void uupdateAnimation()
    {
        if(electric==true && prepinac == true) {
            setAnimation(light_on);
        }
            else setAnimation(light_off);
    }

    public void toggle()
    {
            if(prepinac ==false)//this.prepinac == true
            {
                prepinac = true;
                uupdateAnimation();
            }
            else
            {
                prepinac = false;
                uupdateAnimation();
            }
    }


    public void setElectricityFlow(boolean electric)
    {
        this.electric = electric;
        if(this.electric == true)
        {
            if(this.prepinac == true)
            {
                prepinac = true;
                setAnimation(light_on);
            }
            else
            {
                prepinac = false;
                setAnimation(light_off);}
        }
        else {
            prepinac = false;
            setAnimation(light_off);
        }
    }

    @Override
    public void turnOn() {
        prepinac = true;
        if(electric == true && prepinac ==true) {
            setAnimation(light_on);
        }
        else setAnimation(light_off);
    }

    @Override
    public void turnOff() {
           prepinac = false;
           setAnimation(light_off);
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
        if(this.electric == true && this.prepinac == true)
        {
            setAnimation(light_on);
        }
        else setAnimation(light_off);
    }
}
