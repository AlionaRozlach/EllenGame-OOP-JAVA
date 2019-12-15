package sk.tuke.kpi.oop.game.weapons;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.Direction;
import sk.tuke.kpi.oop.game.Movable;
//import sk.tuke.kpi.oop.game.characters.Alien;
import sk.tuke.kpi.oop.game.characters.Alive;

import java.util.ArrayList;
import java.util.List;

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
        List<Actor> actors = new ArrayList<>();

        for(int i=0;i<scene.getActors().size();i++)
        {
           actors.add(i,scene.getActors().get(i));
        }

        if(!actors.isEmpty())
        {
        for (int i = 0; i < scene.getActors().size(); i++) {
            if (this.intersects(actors.get(i)) && actors.get(i) instanceof Alive) {
                ((Alive) actors.get(i)).getHealth().drain(10);
                this.collidedWithWall();
            }
        }
        }
    }


    public void addedToScene(@NotNull Scene scene) {
        super.addedToScene(scene);
        interAli(scene);
    }

}
