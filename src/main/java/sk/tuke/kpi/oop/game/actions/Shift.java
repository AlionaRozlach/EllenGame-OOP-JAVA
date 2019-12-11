package sk.tuke.kpi.oop.game.actions;

import sk.tuke.kpi.gamelib.framework.actions.AbstractAction;
import sk.tuke.kpi.oop.game.Keeper;
import sk.tuke.kpi.oop.game.items.Backpack;

public class Shift <B extends Keeper> extends AbstractAction<B> {

   private Backpack backpack;
    @Override
    public void execute(float deltaTime) {

        backpack.shift();
        isDone();
    }
}
