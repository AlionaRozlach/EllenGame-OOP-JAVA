package sk.tuke.kpi.oop.game.actions;

import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.framework.actions.AbstractAction;
import sk.tuke.kpi.oop.game.Keeper;
import sk.tuke.kpi.oop.game.items.Backpack;

public class Drop <A extends Keeper> extends AbstractAction<A> {

    @Override
    public void execute(float deltaTime) {
        if(getActor()!=null && getActor().getBackpack()!=null && getActor().getScene()!=null && getActor().getBackpack().peek()!=null)
        {
        Actor actor = getActor();
        Scene scene = actor.getScene();
        Backpack backpack = getActor().getBackpack();
        if(actor!=null && scene!= null && backpack.peek()!=null && backpack!=null) {
            int x = actor.getPosX();
            int y = actor.getPosY();
            scene.addActor(backpack.peek(), x, y);
            backpack.remove(backpack.peek());
        }

        }setDone(true);
    }
}
