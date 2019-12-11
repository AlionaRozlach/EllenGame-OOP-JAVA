package sk.tuke.kpi.oop.game.actions;


import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.framework.actions.AbstractAction;
import sk.tuke.kpi.oop.game.Keeper;
import sk.tuke.kpi.oop.game.items.Backpack;
import sk.tuke.kpi.oop.game.items.Collectible;


import java.util.List;

public class Take <A extends Keeper> extends AbstractAction<A> {
   private Scene scene;
   private Collectible wrench;
   private Backpack backpack;
    @Override
    public void execute(float deltaTime) {

        List<Actor> myList = scene.getActors();

        for(int i = 0; i!= myList.size(); i++)
        {
            if(myList.get(i) instanceof Collectible)
            {
                if(myList.get(i).intersects(getActor()))
                {

                    backpack.add((Collectible) myList.get(i));
                    scene.removeActor(myList.get(i));
                }
            }
        }
        setDone(true);

        //vynimka
    }

}
