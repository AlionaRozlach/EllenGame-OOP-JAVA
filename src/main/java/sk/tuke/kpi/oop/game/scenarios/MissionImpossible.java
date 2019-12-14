package sk.tuke.kpi.oop.game.scenarios;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.ActorFactory;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.SceneListener;
import sk.tuke.kpi.oop.game.Locker;
import sk.tuke.kpi.oop.game.Ventilator;
import sk.tuke.kpi.oop.game.characters.Ripley;
import sk.tuke.kpi.oop.game.items.AccessCard;
import sk.tuke.kpi.oop.game.items.Energy;

import sk.tuke.kpi.oop.game.openables.LockedDoor;

public class MissionImpossible implements SceneListener {

    private Ripley ripley;

    @Override
    public void sceneInitialized(@NotNull Scene scene) {
        ripley= (Ripley) scene.getFirstActorByName("Ellen");
    }

    public static class Factory implements ActorFactory
    {

        @Override
        public @Nullable Actor create(@Nullable String type, @Nullable String name) {
            if(name!=null)
            {
                if(name == "Ellen") return new Ripley();
                else if(name == "energy") return new Energy();
                else if(name == "door") return new LockedDoor();
                else if(name == "access card") return new AccessCard();
                else if(name == "ventilator") return new Ventilator();
                else if(name == "locker") return new Locker();
                else return null;
            }
            else return null;
        }
    }

    @Override
    public void sceneUpdating(@NotNull Scene scene) {

        if(ripley!=null)
            ripley.showRipleyState(scene);

    }
}
