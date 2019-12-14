package sk.tuke.kpi.oop.game.scenarios;

import org.jetbrains.annotations.Nullable;
import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.ActorFactory;

public class EscapeRoom {

    public static class Factory implements ActorFactory
    {

        @Override
        public @Nullable Actor create(@Nullable String type, @Nullable String name) {
            return null;
        }
    }
}
