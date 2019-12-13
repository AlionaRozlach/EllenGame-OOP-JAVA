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
        if(isDone()==false)
        {
            grac.startedMoving(direction);
        }
        if(direction == Direction.NORTH)
        {
            grac.setPosition((grac.getPosX()),(grac.getPosY()+grac.getSpeed()));
            if(grac.getScene().getMap().intersectsWithWall(grac))
            {
                grac.setPosition((grac.getPosX()),(grac.getPosY()-grac.getSpeed()));
            }
        }
        else if(direction == Direction.SOUTH)
        {
            grac.setPosition((grac.getPosX()),(grac.getPosY()-grac.getSpeed()));
            if(grac.getScene().getMap().intersectsWithWall(grac))
            {
                grac.setPosition((grac.getPosX()),(grac.getPosY()+grac.getSpeed()));
            }
        }
        else if(direction == Direction.EAST)
        {
            grac.setPosition((grac.getPosX()+grac.getSpeed()),(grac.getPosY()));
            if(grac.getScene().getMap().intersectsWithWall(grac))
            {
                grac.setPosition((grac.getPosX()-grac.getSpeed()),(grac.getPosY()));
            }
        }
        else{
            grac.setPosition((grac.getPosX()-grac.getSpeed()),(grac.getPosY()));
            if(grac.getScene().getMap().intersectsWithWall(grac))
            {
                grac.setPosition((grac.getPosX()+grac.getSpeed()),(grac.getPosY()));
            }
        }

        timik += deltaTime;
        if(timik>=duration) state = true;
        if(isDone()) grac.stoppedMoving();
    }

    @Override
    public void reset() {
        direction=Direction.NORTH;
        grac.stoppedMoving();
    }

    public void stop()
    {
        state = true;
        grac.stoppedMoving();
    }



}
