package sk.tuke.kpi.oop.game.actions;

import org.jetbrains.annotations.Nullable;
import sk.tuke.kpi.gamelib.actions.Action;
import sk.tuke.kpi.oop.game.Direction;
import sk.tuke.kpi.oop.game.Movable;



public class Move<A extends Movable> implements Action<A> {


    private Direction direction;
    private float duration;
    private A grac;
    private boolean state=false;
    private float timik=0;

    public Move(Direction direction, float duration) {
        this.direction = direction;
        this.duration = duration;
    }

    public Move(Direction direct) {
        this.direction = direct;
    }


    @Nullable
    @Override
    public A getActor() {
        return grac;
    }

    @Override
    public void setActor(@Nullable A actor) {
        grac = actor;
    }

    @Override
    public boolean isDone() {
        return state;
    }

    @Override
    public void execute(float deltaTime) {
        if(grac!=null) {
            if (isDone() == true) {
                grac.startedMoving(direction);
                state=false;
            }
            if (direction == Direction.NORTH) {
                directNorth();
            } else if (direction == Direction.SOUTH) {
                directSouth();
            } else if (direction == Direction.EAST) {
                directEast();
            } else {
                directWest();
            }

            timik += deltaTime;
            if (timik >= duration) state = true;
            if (isDone()) grac.stoppedMoving();
        }
    }

    private void directNorth()
    {
        grac.setPosition((grac.getPosX()),(grac.getPosY()+grac.getSpeed()));
        if(grac.getScene().getMap().intersectsWithWall(grac))
        {
            grac.setPosition((grac.getPosX()),(grac.getPosY()-grac.getSpeed()));
        }
    }

    private void directSouth()
    {
        grac.setPosition((grac.getPosX()),(grac.getPosY()-grac.getSpeed()));
        if(grac.getScene().getMap().intersectsWithWall(grac))
        {
            grac.setPosition((grac.getPosX()),(grac.getPosY()+grac.getSpeed()));
        }
    }

    private void directEast()
    {
        grac.setPosition((grac.getPosX()+grac.getSpeed()),(grac.getPosY()));
        if(grac.getScene().getMap().intersectsWithWall(grac))
        {
            grac.setPosition((grac.getPosX()-grac.getSpeed()),(grac.getPosY()));
        }
    }

    private void directWest()
    {
        grac.setPosition((grac.getPosX()-grac.getSpeed()),(grac.getPosY()));
        if(grac.getScene().getMap().intersectsWithWall(grac))
        {
            grac.setPosition((grac.getPosX()+grac.getSpeed()),(grac.getPosY()));
        }
    }

    @Override
    public void reset() {
        direction=Direction.NORTH;
        grac.stoppedMoving();
        state=false;
    }

    public void stop()
    {
        state = true;
        grac.stoppedMoving();
    }



}
