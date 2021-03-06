package sk.tuke.kpi.oop.game.actions;


import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.framework.actions.AbstractAction;
import sk.tuke.kpi.oop.game.Keeper;
import sk.tuke.kpi.oop.game.items.Backpack;

public class Shift <B extends Keeper> extends AbstractAction<B> {


    @Override
    public void execute(float deltaTime) {
       if(getActor()!=null) {
           Actor actor = getActor();
           Backpack backpack = getActor().getBackpack();
           Scene scene = actor.getScene();
           if (actor != null && backpack != null && scene != null) {
               backpack.shift();
           }
       }
       setDone(true);
    }


}
