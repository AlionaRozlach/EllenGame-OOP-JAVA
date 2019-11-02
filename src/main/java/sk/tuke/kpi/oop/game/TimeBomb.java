package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.framework.actions.Loop;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class TimeBomb extends AbstractActor {

    private float time_tik;
    private boolean state;
    private Animation bomb_activated;
    private Animation bomb;
    private Animation explos;
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
            setAnimation(explos);
        }
    }

    public void tik_tok()
    {
        if(this.time_tik>0)
            this.time_tik--;
    }

    public boolean isActivated()
    {
        return state;
    }
}
