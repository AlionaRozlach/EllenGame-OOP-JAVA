package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.Actor;

public interface Movable extends Actor {
    int getSpeed();
   default public void startedMoving(Direction direction) {}
   default public void stoppedMoving() {}

}
