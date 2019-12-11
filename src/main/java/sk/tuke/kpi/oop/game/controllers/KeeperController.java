package sk.tuke.kpi.oop.game.controllers;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Input;
import sk.tuke.kpi.gamelib.KeyboardListener;
import sk.tuke.kpi.gamelib.framework.actions.AbstractAction;
import sk.tuke.kpi.oop.game.Keeper;
import sk.tuke.kpi.oop.game.Movable;
import sk.tuke.kpi.oop.game.actions.Drop;
import sk.tuke.kpi.oop.game.actions.Move;
import sk.tuke.kpi.oop.game.actions.Shift;
import sk.tuke.kpi.oop.game.actions.Take;

import java.util.Map;

public class KeeperController implements KeyboardListener {

    private Map<Input.Key, AbstractAction<Keeper>> keyDirectionMap = Map.ofEntries(
        Map.entry(Input.Key.ENTER, new Take<>()),
        Map.entry(Input.Key.S, new Shift<>()),
      Map.entry(Input.Key.BACKSPACE, new Drop<>())
    );



    private Keeper a;
    public KeeperController(Keeper a)
    {
        this.a = a;
    }

    @Override
    public void keyPressed(Input.@NotNull Key key) {
            if(keyDirectionMap.containsKey(key))
            {
                keyDirectionMap.get(key).scheduleFor(a);
            }

    }
}
