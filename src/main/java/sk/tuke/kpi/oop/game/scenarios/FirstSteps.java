package sk.tuke.kpi.oop.game.scenarios;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.GameApplication;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.SceneListener;
import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.actions.When;
import sk.tuke.kpi.gamelib.framework.actions.AbstractAction;
import sk.tuke.kpi.gamelib.framework.actions.Loop;
import sk.tuke.kpi.gamelib.graphics.Color;
import sk.tuke.kpi.gamelib.graphics.Font;
import sk.tuke.kpi.oop.game.Keeper;
import sk.tuke.kpi.oop.game.actions.Use;
import sk.tuke.kpi.oop.game.characters.Ripley;
import sk.tuke.kpi.oop.game.controllers.KeeperController;
import sk.tuke.kpi.oop.game.controllers.MovableController;
import sk.tuke.kpi.oop.game.items.*;


public class FirstSteps implements SceneListener {

    @Override
    public void sceneInitialized(@NotNull Scene scene) {

        Ripley ripley = new Ripley();
        scene.addActor(ripley,0,0);

        /*Move<Ripley> move = new Move<>(Direction.SOUTH,2);
        move.scheduleFor(ripley);*/



        MovableController move = new MovableController(ripley);
        scene.getInput().registerListener(move);

        Energy energy = new Energy();
        scene.addActor(energy,0,0);

        Ammo ammo = new Ammo();
        scene.addActor(ammo,0,-30);

        Hammer hammer = new Hammer();
        FireExtinguisher fire = new FireExtinguisher();
        Wrench wrench = new Wrench();

        Backpack backpack = ripley.getBackpack();

       /* new When<>(()->ammo.intersects(ripley) ,new Invoke<>(() ->new Use<>(ammo).scheduleFor(ripley)
        )).scheduleFor(ripley);*/



        KeeperController keep = new KeeperController(ripley);
        scene.getInput().registerListener(keep);

        scene.getGame().getOverlay();
        int windowHeight = scene.getGame().getWindowSetup().getHeight();
        int yTextPos = windowHeight - GameApplication.STATUS_LINE_OFFSET;

        new Loop<>(new Invoke<>(() -> {
            String text = "| Energy: " + ripley.getEnergy()+"| Ammo: "+ ripley.getAmmo();
            scene.getGame().getOverlay().drawText(text, 100, yTextPos, new Font(16, Color.WHITE));
        })).scheduleFor(ripley);


        backpack.add(hammer);
        backpack.add(fire);
        backpack.add(wrench);
        scene.getGame().pushActorContainer(ripley.getBackpack());
        backpack.shift();

    }
}
