package sk.tuke.kpi.oop.game.characters;


import sk.tuke.kpi.gamelib.GameApplication;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.framework.AbstractActor;

import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.gamelib.messages.Topic;
import sk.tuke.kpi.oop.game.Direction;
import sk.tuke.kpi.oop.game.Keeper;
import sk.tuke.kpi.oop.game.Movable;
import sk.tuke.kpi.oop.game.Reactor;
import sk.tuke.kpi.oop.game.items.Backpack;

public class Ripley extends AbstractActor implements Movable, Keeper {
    private Animation grac;
    private int energy=50;
    private int naboj = 10;
    private Backpack backpack = new Backpack("Ripley's backpack",10);

    public static final Topic<Ripley> RIPLEY_DIED = Topic.create("Ripley died", Ripley.class);

    public Ripley()
    {
        super("Ellen");

        grac = new Animation("sprites/player.png",32,32,0.1f, Animation.PlayMode.LOOP_PINGPONG);
        setAnimation(grac);
        grac.stop();

        if(energy==0) {
            setAnimation(new Animation("sprites/player_die.png", 32, 32, 0.1f, Animation.PlayMode.ONCE));
            this.getScene().getMessageBus().publish(RIPLEY_DIED, this);
        }
    }

    @Override
    public int getSpeed() {
        return 1;
    }

    public void startedMoving(Direction direction) {
            grac.setRotation(direction.getAngle());
            grac.play();
    }

    public int getEnergy()
    {
        return energy;
    }

    public void setEnergy(int energy)
    {
        if(energy<0 || energy>100) return;
        this.energy = energy;
    }


    public  int getAmmo()
    {
        return naboj;
    }

    public void setAmmo(int naboj)
    {
        this.naboj = naboj;
    }
    public void stoppedMoving(){
        grac.stop();
    }

    @Override
    public Backpack getBackpack() {
        return this.backpack;
    }

    public void showRipleyState(Scene scene)
    {
        int windowHeight = scene.getGame().getWindowSetup().getHeight();
        int yTextPos = windowHeight - GameApplication.STATUS_LINE_OFFSET;
        scene.getGame().getOverlay().drawText("| Energy: " + getEnergy()+"| Ammo: "+ getAmmo(), 100, yTextPos);
    }
}
