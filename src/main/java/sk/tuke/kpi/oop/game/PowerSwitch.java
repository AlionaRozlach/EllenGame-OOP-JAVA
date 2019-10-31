package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.gamelib.graphics.Color;

public class PowerSwitch extends AbstractActor {

    private Reactor reactor;
    private Animation PowerSwitch;
    private Switchable device;

    public PowerSwitch(Switchable device)
    {
        this.device = device;
        PowerSwitch = new Animation("sprites/switch.png",16,16);
        setAnimation(PowerSwitch);
    }

    public void toggle()
    {
        if(device != null) {
            if (device.isOn() == true) {
                device.turnOff();
            } else device.turnOn();
        }
    }

   public Switchable getDevice()
   {
        return device;
   }

    public void switchOn()
    {
        if(device != null) {
            if (device.isOn() == false) {
                device.turnOn();
                getAnimation().setTint(Color.WHITE);
            }
        }
        return;
    }

    public void switchOff()
    {
        if(device != null)
        {
            if(device.isOn() == true)
            {
                device.turnOff();
                getAnimation().setTint(Color.GRAY);
            }
        }
    }
}
