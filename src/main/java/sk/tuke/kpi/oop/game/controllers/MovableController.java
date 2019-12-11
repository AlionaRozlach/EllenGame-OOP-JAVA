package sk.tuke.kpi.oop.game.controllers;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Input;
import sk.tuke.kpi.gamelib.KeyboardListener;
import sk.tuke.kpi.oop.game.Direction;
import sk.tuke.kpi.oop.game.Movable;
import sk.tuke.kpi.oop.game.actions.Move;

import java.util.Map;

public class MovableController implements KeyboardListener {

    private Map<Input.Key, Direction> keyDirectionMap = Map.ofEntries(Map.entry(Input.Key.UP, Direction.NORTH),
        Map.entry(Input.Key.RIGHT, Direction.EAST),Map.entry(Input.Key.DOWN, Direction.SOUTH),Map.entry(Input.Key.LEFT, Direction.WEST));
    private Move<Movable> move;
    private Movable a;
    public MovableController(Movable a)
    {
        this.a = a;
    }

    @Override
    public void keyPressed(Input.@NotNull Key key) {
        if(keyDirectionMap.containsKey(key))
        {
            Direction direct = keyDirectionMap.get(key);
            move = new Move<>(direct,100);
            move.scheduleFor(a);
        }
    }

    @Override
    public void keyReleased(Input.@NotNull Key key) {
        if(keyDirectionMap.containsKey(key))
        {
            move.stop();
        }
    }
}
