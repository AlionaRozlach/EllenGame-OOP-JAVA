package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Computer extends AbstractActor implements EnergyConsumer{
    private int a;
    private int b;
    private float c;
    private float d;
    private Animation normalAnimation ;

    private boolean electricity;

    public Computer()
    {
        normalAnimation = new Animation("sprites/computer.png", 80, 48, 0.2f, Animation.PlayMode.LOOP_PINGPONG);
        setAnimation(normalAnimation);

    }



    private int add(int a, int b) {
        if (this.electricity == true) {
            return a + b;
        }
        normalAnimation.stop();
        return 0;
    }

    private float add(float c, float d)
    {
        if(this.electricity == true) {
            return c + d;
        }
        normalAnimation.stop();
        return 0;
    }

    private int sub(int a, int b)
    {
        if(this.electricity == true) {
            return a * b;
        }
        normalAnimation.stop();
        return 0;
    }

    private float sub(float c, float d)
    {
        if(this.electricity == true) {
            return c * d;
        }
        normalAnimation.stop();
        return 0;
    }

    @Override
    public void setPowered(boolean power) {
        this.electricity = power;
    }
}
