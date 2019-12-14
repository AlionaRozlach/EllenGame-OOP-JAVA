package sk.tuke.kpi.oop.game.controllers;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Input;
import sk.tuke.kpi.gamelib.KeyboardListener;
import sk.tuke.kpi.gamelib.framework.actions.AbstractAction;
import sk.tuke.kpi.oop.game.Keeper;

import sk.tuke.kpi.oop.game.actions.Drop;

import sk.tuke.kpi.oop.game.actions.Shift;
import sk.tuke.kpi.oop.game.actions.Take;
import sk.tuke.kpi.oop.game.actions.Use;
import sk.tuke.kpi.oop.game.items.Collectible;
import sk.tuke.kpi.oop.game.items.Usable;

import java.util.Map;

public class KeeperController implements KeyboardListener {

    private Map<Input.Key, AbstractAction<Keeper>> keyDirectionMap = Map.ofEntries(
        Map.entry(Input.Key.ENTER, new Take<>()),
        Map.entry(Input.Key.S, new Shift<>()),
      Map.entry(Input.Key.BACKSPACE, new Drop<>())
    );



    private Keeper actor;
    public KeeperController(Keeper a)
    {
        this.actor = a;
    }

    @Override
    public void keyPressed(@NotNull Input.Key key) {
            if(key == Input.Key.B)
            {
                Collectible use = actor.getBackpack().peek();
                if(use instanceof Usable)
                {
                    new Use<>((Usable<?>)use).scheduleForIntersectingWith(actor);
                    actor.getBackpack().remove(use);
                }
            }
            if(key== Input.Key.U)
            {
                //if(actor.intersects())
            }
            if(keyDirectionMap.containsKey(key))
            {
                keyDirectionMap.get(key).scheduleFor(actor);
            }

    }
}
