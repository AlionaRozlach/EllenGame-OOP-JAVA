package sk.tuke.kpi.oop.game.openables;

import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.gamelib.map.MapTile;
import sk.tuke.kpi.gamelib.messages.Topic;
import sk.tuke.kpi.oop.game.items.Usable;

public class Door extends AbstractActor implements Openable, Usable<Actor> {

    private Animation door_close;
    private Animation door_open;
    private boolean state;

    public static final Topic<Door> DOOR_OPENED = Topic.create("door opened", Door.class);
    public static final Topic<Door> DOOR_CLOSED = Topic.create("door closed", Door.class);

  public Door()
  {
      //super("door");
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
        getScene().getMap().getTile(this.getPosX()/16,this.getPosY()/16).setType(MapTile.Type.CLEAR);
        getScene().getMap().getTile(this.getPosX()/16,this.getPosY()/16+1).setType(MapTile.Type.CLEAR);

        this.getScene().getMessageBus().publish(DOOR_OPENED, this);
    }

    @Override
    public void close() {
        if(state == true)
        {
            setAnimation(door_close);
            state=false;
            door_close.stop();
        }
        getScene().getMap().getTile(this.getPosX()/16,this.getPosY()/16).setType(MapTile.Type.WALL);
        getScene().getMap().getTile(this.getPosX()/16,this.getPosY()/16+1).setType(MapTile.Type.WALL);

        this.getScene().getMessageBus().publish(DOOR_CLOSED, this);
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
    public Class<Actor> getUsingActorClass() {
        return Actor.class;
    }
}
