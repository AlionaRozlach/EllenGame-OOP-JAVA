package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.framework.Player;
import sk.tuke.kpi.gamelib.framework.actions.Loop;
import sk.tuke.kpi.gamelib.graphics.Animation;


public class Helicopter extends AbstractActor {

    private Animation helicopter;
   private Player player;

    //private Actor helik;
    //private Actor play;

    public Helicopter() {
        helicopter = new Animation("sprites/heli.png",64,64,0.07f, Animation.PlayMode.LOOP_REVERSED);
        setAnimation(helicopter);
        new Loop<>(new Invoke<>(this::searchAndDestroy)).scheduleFor(this);
    }

  public void searchAndDestroy()
    {
        player = (Player)getScene().getFirstActorByName("Player");
        int x_act = player.getPosX();
        int y_act = player.getPosY();

        int x_helic = getPosX();
        int y_helic = getPosY();

        int x;
        int y;

        if(y_act>y_helic) y = 1+y_helic;
        else y = y_helic -1;

        if(x_act>x_helic) x = 1+x_helic;
        else x = x_helic - 1;

        setPosition(x,y);

        int energ = player.getEnergy();
        boolean kontakt = intersects(player);

        if(kontakt == true){
            player.setEnergy(energ-1);
        }

    }
}
