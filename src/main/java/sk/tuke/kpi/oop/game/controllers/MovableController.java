package sk.tuke.kpi.oop.game.controllers;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Input;
import sk.tuke.kpi.gamelib.KeyboardListener;
import sk.tuke.kpi.oop.game.Direction;
import sk.tuke.kpi.oop.game.Movable;
import sk.tuke.kpi.oop.game.actions.Move;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MovableController implements KeyboardListener {

    private Map<Input.Key, Direction> keyDirectionMap = Map.ofEntries(Map.entry(Input.Key.UP, Direction.NORTH),
        Map.entry(Input.Key.RIGHT, Direction.EAST),Map.entry(Input.Key.DOWN, Direction.SOUTH),Map.entry(Input.Key.LEFT, Direction.WEST));
    private Move<Movable> move;
    private Movable a;
    private Set<Direction> directik = new HashSet<>();
    public MovableController(Movable a)
    {
        this.a = a;
    }

    @Override
    public void keyPressed(@NotNull Input.Key key) {
        if(keyDirectionMap.containsKey(key))
        {
            Direction direct = keyDirectionMap.get(key);

            if(this.directik.isEmpty() != true)
            {
              Direction[] di = new Direction[this.directik.size()];
              Direction dir = di[0];
              for(int i=0;i<this.directik.size();i++)
              {
                  dir = dir.combine(di[i]);
              }
              move = new Move<>(dir,100);
              move.scheduleFor(a);
            }
            else
            {
                move = new Move<>(direct,100);
                move.scheduleFor(a);
            }
        }
    }

    @Override
    public void keyReleased(@NotNull Input.Key key) {
        if(keyDirectionMap.containsKey(key))
        {
            if(this.directik.isEmpty() != true)
            {
                Direction[] di = new Direction[this.directik.size()];
                Direction dir = di[0];
                for(int i=0;i<this.directik.size();i++)
                {
                    dir = dir.combine(di[i]);
                }
                move.stop();
                move = new Move<>(dir,100);
                if(a.getScene()!=null)
                {
                    move.scheduleFor(a);
                }

            }
            else {
                move.stop();
            }
        }
    }
}
