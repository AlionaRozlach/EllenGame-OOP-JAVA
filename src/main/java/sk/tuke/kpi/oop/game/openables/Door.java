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
      door_close = new Animation("sprites/vdoor.png ",16,32,0.1f,Animation.PlayMode.ONCE_REVERSED);
      door_close.stop();
      state = false;
      setAnimation(door_close);

      door_open = new Animation("sprites/vdoor.png",16,32,0.1f,Animation.PlayMode.ONCE);

  }

    @Override
    public void open() {
        if(state==false)
        {
            setAnimation(door_open);
            state = true;
            door_open.play();
        }
    }

    @Override
    public void close() {
        if(state == true)
        {
            setAnimation(door_close);
            state=false;
            door_close.stop();
        }
    }

    @Override
    public boolean isOpen() {
        return state;
    }

    @Override
    public void useWith(Actor actor) {
        if(actor!=null && state==false)
        {
            if(state == true)
            {
                close();
            }
            else open();
        }
    }
}
