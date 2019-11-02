package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.actions.When;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.framework.Player;
import sk.tuke.kpi.gamelib.framework.actions.Loop;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class TimeBomb extends AbstractActor {

    private float time_tik;
    private boolean state;
    private Animation bomb_activated;
    private Animation bomb;
    private Animation explos;
    private Player player;

    public TimeBomb(float time)
    {
        time_tik = time;
         bomb = new Animation("sprites/bomb.png");
         bomb_activated = new Animation("sprites/bomb_activated.png",16,16,0.1f,Animation.PlayMode.LOOP_PINGPONG);
         explos = new Animation("sprites/small_explosion.png",16,16,0.1f,Animation.PlayMode.ONCE);
         setAnimation(bomb);
    }

    public void activate()
    {
        if(state == false)
        {
            setAnimation(bomb_activated);
            state = true;
            new Loop<>(new Invoke<>(this::tik_tok)).scheduleFor(this);
        }
    }

    public boolean akskoncila()
    {
        int count_cadr = explos.getFrameCount();
        int tera_cadr = explos.getCurrentFrameIndex();

        if(count_cadr == tera_cadr) return true;
        else return false;
    }


    public void tik_tok()
    {
        if(this.time_tik>0)
            this.time_tik--;
        if(time_tik == 0) setAnimation(explos);
    }

    public boolean isActivated()
    {
        return state;
    }
}
