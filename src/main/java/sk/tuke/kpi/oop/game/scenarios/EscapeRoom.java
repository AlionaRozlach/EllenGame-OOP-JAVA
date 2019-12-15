package sk.tuke.kpi.oop.game.scenarios;

import org.jetbrains.annotations.Nullable;
import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.ActorFactory;
import sk.tuke.kpi.gamelib.SceneListener;
import sk.tuke.kpi.oop.game.characters.Alien;
import sk.tuke.kpi.oop.game.items.Ammo;
import sk.tuke.kpi.oop.game.items.Energy;

public class EscapeRoom implements SceneListener {

    public static class Factory implements ActorFactory
    {


        @Override
        public @Nullable Actor create(@Nullable String type, @Nullable String name) {
            if(name!=null)
            {
                if(name=="alien") return new Alien();
                else if(name=="energy") return new Energy();
                else if(name == "ammo") return new Ammo();
                else return null;
            }
            else return null;
        }
    }
}
