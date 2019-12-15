package sk.tuke.kpi.oop.game.weapons;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.framework.actions.Loop;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.Direction;
import sk.tuke.kpi.oop.game.Movable;

import sk.tuke.kpi.oop.game.characters.Alive;


public class Bullet extends AbstractActor implements Fireable, Movable {

    private Animation bull;

    public Bullet() {
        bull = new Animation("sprites/bullet.png", 16, 16);
        setAnimation(bull);
    }

    @Override
    public int getSpeed() {
        return 8;
    }

    @Override
    public void collidedWithWall() {
        if (getScene() != null) {
            getScene().removeActor(this);
        }
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

    private void interAli(Scene scene) {
        new Loop<>(
            new Invoke<>(() -> {
                for (Actor act : scene.getActors()) {
                    cyklus(act);
                }
            })
        ).scheduleFor(this);
    }

    private void cyklus(Actor act)
    {
        if ((this.intersects(act)) && ((act instanceof Alive))) {
            ((Alive) act).getHealth().drain(20);
            collidedWithWall();
        }
        else
        {
            collidedWithWall();
        }
    }

    public void addedToScene(@NotNull Scene scene) {
        super.addedToScene(scene);
        interAli(scene);
    }

}
