package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.actions.PerpetualReactorHeating;
import sk.tuke.kpi.oop.game.tools.FireExtinguisher;
import sk.tuke.kpi.oop.game.tools.Hammer;

import java.util.HashSet;
import java.util.Set;

public class Reactor extends AbstractActor implements Switchable{
    private int temperature;
    private int damage;
    private boolean state;
    private EnergyConsumer device;
    private Animation normalAnimation;
    private Animation hotAnimation;
    private Animation brokenAnimation;
    private Animation reactor_off;
    private Animation ext;
    private Set<EnergyConsumer> devices;




    public Reactor()
    {
        state = false;
        temperature = 0;
        damage = 0;
        normalAnimation = new Animation("sprites/reactor_on.png", 80, 80, 0.1f, Animation.PlayMode.LOOP_PINGPONG);
        hotAnimation = new Animation("sprites/reactor_hot.png", 80, 80, 0.05f);
        brokenAnimation = new Animation("sprites/reactor_broken.png", 80, 80, 0.1f);
        reactor_off = new Animation("sprites/reactor.png");
        ext = new Animation("sprites/reactor_extinguished.png");
        devices = new HashSet<>();
        setAnimation(reactor_off);
        setPosition(10, 10);
    }

    public int getTemperature()
    {
        return temperature;
    }

    public int getDamage()
    {
        return damage;
    }

    private void updateAnimation()
    {
        if(this.temperature>=4000 && this.temperature<6000)
        {
            setAnimation(hotAnimation);
        }
        else if(this.temperature>=6000)
        {
            setAnimation(brokenAnimation);
        }
        else
        {
            setAnimation(normalAnimation);
        }
    }


    public void increaseTemperature(int increment)
    {
        if(this.state == true && increment>0) {
            if (damage >= 33 && damage <= 66) temperature += 1.5 * increment;
            else if (damage > 66) temperature += 2 * increment;
            else temperature += increment;
            if (this.temperature > 2000 && this.damage < 33 && temperature < 6000) {
                damage = (int) Math.floor((temperature - 2000) / 40);
            }
            if (temperature >= 6000) {
                damage = 100;
                this.state = false;
                updateAnimation();
            }
            if (temperature > 4000 && temperature < 6000) {
                updateAnimation();
            }
            if (damage > 100)
            {
                this.damage = 100;
                this.state = false;
            }
            if (increment < 0) temperature = temperature;
        }
        else return;
    }

    public void decreaseTemperature(int decrease)
    {
        if(state == true && decrease>0) {
            if (this.damage >= 50 && this.damage < 100) this.temperature -= decrease / 2;
            if (damage < 50) this.temperature -= decrease;
            if (this.temperature < 0) {
                this.temperature = 0;
                updateAnimation();
            }
            if (decrease < 0) this.temperature = this.temperature;
        }
        else return;
    }

    public boolean repair(Hammer hammer)
    {
       if(this.damage< 0 || this.damage>100) return false;
        if(hammer != null && this.damage>0 && this.damage<100)
        {
            if (this.damage > 50) {
                this.damage-=50;
                this.temperature= this.temperature -((this.damage * 40) + 2000);
                updateAnimation();

            }
            else{
                this.damage = 0;
                this.temperature = this.temperature - 2000;
                updateAnimation();
            }
            return true;
        }
        else return false;
    }

    public boolean extinguish(FireExtinguisher fire)
    {
        if(fire != null) {
            this.temperature -= 4000;
            setAnimation(ext);
            return true;
        }
        else return false;
    }

    @Override
    public void turnOn()
    {
        if(this.state == false)
        {
            this.state = true;
            updateAnimation();
        }
        else return;
    }

    public void update_off()
    {
        if(this.damage<0 || this.damage>100) return;

        if(this.damage != 100)
        {
            setAnimation(reactor_off);
        }
        else if(this.damage == 100)
        {
            setAnimation(brokenAnimation);
        }
    }

    @Override
    public void turnOff()
    {
        if(this.state == true)
        {
            this.state = false;
            update_off();
        }
        else return;
    }

    @Override
    public boolean isOn()
    {
        if(this.state == true) return true;
        else return false;
    }

    public void addDevice(EnergyConsumer device)
    {
        if(device==null) return;
        devices.add(device);
        if(isOn() == true && this.damage<100)
        {
            this.device.setPowered(true);
        }
        //else return;
    }

    public void removeDevice(EnergyConsumer device)
    {
        if(device==null) return;
        devices.remove(device);
            this.device.setPowered(false);

       // else return;
    }

    @Override
    public void addedToScene(Scene scene)
    {
        if(scene == null) return;
        super.addedToScene(scene);
        new PerpetualReactorHeating(1).scheduleFor(this);
    }
}




