package sk.tuke.kpi.oop.game.openables;

import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.items.Usable;

public class Door extends AbstractActor implements Openable, Usable<Actor> {

    private Animation door_close;
    private Animation door_open;
    private boolean state;

  public Door()
  {
      door_close = new Animation("sprites/vdoor.png ",16,32,01f,Animation.PlayMode.ONCE_REVERSED);
      door_close.stop();
      setAnimation(door_close);

      door_open = new Animation("sprites/vdoor.png",16,32,01.f,Animation.PlayMode.ONCE);

  }

    @Override
    public void open() {

    }

    @Override
    public void close() {

    }

    @Override
    public boolean isOpen() {
        return false;
    }

    @Override
    public void useWith(Actor actor) {

    }
}
