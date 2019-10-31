package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.framework.Player;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.gamelib.Scene;

public class Helicopter extends AbstractActor {

    private Animation helicopter;
    private Player player;

    //private Actor helik;
    //private Actor play;

    public Helicopter() {
        helicopter = new Animation("sprites/ heli.png",64,64,0.07f);
        setAnimation(helicopter);
    }

   /* public void searchAndDestroy()
    {
        player = (Player)getScene().getFirstActorByName("Player");
        int x_act = player.getPosX();
        int y_act = player.getPosY();

        int x_helic = getPosX();
        int y_helic = getPosY();

        if(x_act !=)

    }*/
}
