package sk.tuke.kpi.oop.game.actions;


import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.GameApplication;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.framework.actions.AbstractAction;
import sk.tuke.kpi.oop.game.Keeper;
import sk.tuke.kpi.oop.game.items.Backpack;
import sk.tuke.kpi.oop.game.items.Collectible;


import java.util.List;

public class Take <A extends Keeper> extends AbstractAction<A> {

    @Override
    public void execute(float deltaTime) {
        Actor actor=getActor();
        if(actor!=null) {
            Scene scene = actor.getScene();
            Backpack backpack = getActor().getBackpack();
            if(backpack.getSize()==backpack.getCapacity()) return;
            List<Actor> myList = scene.getActors();
                for (int i = 0; i != myList.size(); i++) {
                    if ((myList.get(i) instanceof Collectible) &&(myList.get(i).intersects(getActor()))) {
                           vynimka(backpack,myList,i);
                            scene.removeActor(myList.get(i));
                            break;
                    }
                }
        }
        setDone(true);

        //vynimka
    }

    public void vynimka(Backpack backpack,List<Actor> myList,int i)
    {
        try {
            backpack.add((Collectible) myList.get(i));
        } catch (Exception e) {
            int windowHeight = getActor().getScene().getGame().getWindowSetup().getHeight();
            int yTextPos = windowHeight - GameApplication.STATUS_LINE_OFFSET;
            getActor().getScene().getGame().getOverlay().drawText(e.getMessage(), 0, yTextPos - 30).showFor(2);
            return;
        }
    }
}
