package sk.tuke.kpi.oop.game.weapons;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.Direction;
import sk.tuke.kpi.oop.game.Movable;

public class Bullet extends AbstractActor implements Fireable, Movable {

    private Animation bull;
    public Bullet()
    {
        bull = new Animation("sprites/bullet.png",16,16);
        setAnimation(bull);
    }

    @Override
    public int getSpeed() {
        return 8;
    }

    @Override
    public void startedMoving(Direction direction) {
        bull.play();
        bull.setRotation(direction.getAngle());
    }

    @Override
    public void stoppedMoving() {
        bull.stop();
    }
}
