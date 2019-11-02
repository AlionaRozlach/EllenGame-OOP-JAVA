package sk.tuke.kpi.oop.game;


//import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.actions.ActionSequence;
import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.actions.Wait;
import sk.tuke.kpi.gamelib.actions.When;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
//import sk.tuke.kpi.gamelib.framework.Player;
//import sk.tuke.kpi.gamelib.framework.actions.Loop;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class TimeBomb extends AbstractActor {

    private float time_tik;
    private boolean state;
    private Animation bomb_activated;
    ;
    private Animation explos;


    public TimeBomb(float time)
    {    Animation bomb;
        time_tik = time;
         bomb = new Animation("sprites/bomb.png");
         bomb_activated = new Animation("sprites/bomb_activated.png",16,16,0.1f,Animation.PlayMode.LOOP_PINGPONG);
         explos = new Animation("sprites/small_explosion.png",16,16,0.1f,Animation.PlayMode.ONCE);
         setAnimation(bomb);
    }

    public void activate()
    {
            setAnimation(bomb_activated);
            state = true;
           new ActionSequence<>(
               new Wait<>(5),
            new Invoke<>(this::tikTok)).scheduleFor(this);
    }

    public void delete()
    {
        Scene  scene = getScene();
        scene.removeActor(this);
    }

    public void tikTok()
    {
       setAnimation(explos);
        new When<>(
            () ->   {
                return getAnimation().getCurrentFrameIndex() >6;
            },
            new Invoke<>(() ->{delete();})).scheduleFor(this);
    }

    public boolean isActivated()
    {
        return state;
    }
}
