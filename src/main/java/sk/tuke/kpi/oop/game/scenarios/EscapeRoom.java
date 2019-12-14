package sk.tuke.kpi.oop.game.scenarios;

import org.jetbrains.annotations.Nullable;
import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.ActorFactory;
import sk.tuke.kpi.gamelib.SceneListener;

public class EscapeRoom implements SceneListener {

    public static class Factory implements ActorFactory
    {


        @Override
        public @Nullable Actor create(@Nullable String type, @Nullable String name) {
            return null;
        }
    }
}
