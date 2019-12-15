package sk.tuke.kpi.oop.game.openables;

import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.gamelib.map.MapTile;
import sk.tuke.kpi.gamelib.messages.Topic;
import sk.tuke.kpi.oop.game.items.Usable;

public class Door extends AbstractActor implements Openable, Usable<Actor> {

    private Animation doorko;
    private Orientation orientation;
    private boolean state;

    public static final Topic<Door> DOOR_OPENED = Topic.create("door opened", Door.class);
    public static final Topic<Door> DOOR_CLOSED = Topic.create("door closed", Door.class);

    public enum Orientation {
        HORIZONTAL, VERTICAL
    }
  public Door(Orientation orientation) {
      super("door");
      if (orientation == Orientation.VERTICAL) {
          doorko = new Animation("sprites/vdoor.png ", 16, 32, 0.1f, Animation.PlayMode.ONCE_REVERSED);
      } else {
          doorko = new Animation("sprites/hdoor.png", 32, 16, 0.1f, Animation.PlayMode.ONCE);
      }
      doorko.stop();
      state = false;
      this.orientation = orientation;
      setAnimation(doorko);
  }

   public Door(String name, Orientation orientation)
    {
        super(name);
        if (orientation == Orientation.VERTICAL) {
            doorko = new Animation("sprites/vdoor.png ", 16, 32, 0.1f, Animation.PlayMode.ONCE_REVERSED);
        } else {
            doorko = new Animation("sprites/hdoor.png", 32, 16, 0.1f, Animation.PlayMode.ONCE);
       }
        doorko.stop();
        state = false;
        this.orientation = orientation;
        setAnimation(doorko);
    }


    @Override
    public void open() {
        if(state==false && getScene()!=null)
        {
            setAnimation(doorko);
            state = true;
            doorko.play();
        }
        control_Orientation_Open();

        this.getScene().getMessageBus().publish(DOOR_OPENED, this);
    }
    private void control_Orientation_Open()
    {
        if(orientation==Orientation.HORIZONTAL) {
            getScene().getMap().getTile(this.getPosX() / 16, this.getPosY() / 16).setType(MapTile.Type.CLEAR);
            getScene().getMap().getTile(this.getPosX() / 16 + 1, this.getPosY() / 16).setType(MapTile.Type.CLEAR);
        }
        else
        {
            getScene().getMap().getTile(this.getPosX() / 16, this.getPosY() / 16).setType(MapTile.Type.CLEAR);
            getScene().getMap().getTile(this.getPosX() / 16, this.getPosY() / 16+1).setType(MapTile.Type.CLEAR);
        }
    }
    @Override
    public void close() {
        if(state == true && getScene()!=null)
        {
            setAnimation(doorko);
            state=false;
            doorko.stop();
        }

        control_Orientation_Close();
        this.getScene().getMessageBus().publish(DOOR_CLOSED, this);
    }

    private void control_Orientation_Close()
    {
        if(orientation==Orientation.HORIZONTAL) {
            getScene().getMap().getTile(this.getPosX() / 16, this.getPosY() / 16).setType(MapTile.Type.WALL);
            getScene().getMap().getTile(this.getPosX() / 16 + 1, this.getPosY() / 16).setType(MapTile.Type.WALL);
        }
        else
        {
            getScene().getMap().getTile(this.getPosX() / 16, this.getPosY() / 16).setType(MapTile.Type.WALL);
            getScene().getMap().getTile(this.getPosX() / 16, this.getPosY() / 16+1).setType(MapTile.Type.WALL);
        }

    }
    @Override
    public boolean isOpen() {
        return state;
    }

    @Override
    public void useWith(Actor actor) {
        if(actor!=null )
        {
            if(state == true)
            {
                close();
            }
            else open();
        }
    }

    public void addedToScene(Scene scene){
        super.addedToScene(scene);
        close();
    }
    public Class<Actor> getUsingActorClass() {
        return Actor.class;
    }
}
