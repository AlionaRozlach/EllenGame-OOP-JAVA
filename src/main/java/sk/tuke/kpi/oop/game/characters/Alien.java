package sk.tuke.kpi.oop.game.characters;


import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.Movable;
import sk.tuke.kpi.oop.game.behaviours.Behaviour;

public class Alien extends AbstractActor implements Movable,Enemy,Alive {

    private Health health;
   // private Behaviour<? super Alien> behaviour;
    public Alien()
    {
        Animation ally;
        ally = new Animation("sprites/alien.png",32,32,0.1f);
        setAnimation(ally);
        health=new Health(100);
      //  this.behaviour=behaviour;
    }

    @Override
    public int getSpeed() {
        return 2;
    }

    @Override
    public Health getHealth() {
        return health;
    }
/*
    @Override
    public void addedToScene(@NotNull Scene scene) {
        super.addedToScene(scene);

        if (behaviour!=null){
            behaviour.setUp(this);
        }
    }*/

}
