package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.gamelib.graphics.Color;

public class PowerSwitch extends AbstractActor {


    private Switchable device;

    public PowerSwitch(Switchable device) {
       Animation switchik;//sdelala lokalnoj
        this.device = device;
        switchik = new Animation("sprites/switch.png", 16, 16);
        setAnimation(switchik);
    }

    public void toggle() {
        if (device != null) {
            if (device.isOn() == true) {
                device.turnOff();
            } else device.turnOn();
        }
    }

    public Switchable getDevice() {
        return device;
    }

    public void switchOn() {
        if (device != null) {
            device.turnOn();
            getAnimation().setTint(Color.WHITE);
        }
    }

        public void switchOff()
        {
            if (device != null) {
                device.turnOff();
                getAnimation().setTint(Color.GRAY);

            }
        }

}

