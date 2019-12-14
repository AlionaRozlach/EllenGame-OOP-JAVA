package sk.tuke.kpi.oop.game.scenarios;

import org.jetbrains.annotations.NotNull;

import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.SceneListener;
import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.actions.When;
import sk.tuke.kpi.oop.game.actions.Use;
import sk.tuke.kpi.oop.game.characters.Ripley;
import sk.tuke.kpi.oop.game.controllers.KeeperController;
import sk.tuke.kpi.oop.game.controllers.MovableController;
import sk.tuke.kpi.oop.game.items.*;


public class FirstSteps implements SceneListener {

    @Override
    public void sceneInitialized(@NotNull Scene scene) {

        Ripley ripley = new Ripley();
        scene.addActor(ripley,30,50);

        /*Move<Ripley> move = new Move<>(Direction.SOUTH,2);
        move.scheduleFor(ripley);*/



        MovableController move = new MovableController(ripley);
        scene.getInput().registerListener(move);

        Energy energy = new Energy();
        scene.addActor(energy,0,0);

        Ammo ammo = new Ammo();
        scene.addActor(ammo,0,-30);

        Hammer hammer = new Hammer();
        scene.addActor(hammer, 5,10);
        FireExtinguisher fire = new FireExtinguisher();

        /*Hammer hammer2 = new Hammer();
        scene.addActor(hammer2, 3,10);
        Hammer hammer1 = new Hammer();
        scene.addActor(hammer1, 82,10);
        Hammer hammer3 = new Hammer();
        scene.addActor(hammer3, 50,10);
        Hammer hammer4 = new Hammer();
        scene.addActor(hammer4, -30,10);
        Hammer hammer5 = new Hammer();
        scene.addActor(hammer5, 93,10);
        Hammer hammer6 = new Hammer();
        scene.addActor(hammer6, -60,10);
        Hammer hammer7 = new Hammer();
        scene.addActor(hammer7, -15,10);
        Hammer hammer8 = new Hammer();
        scene.addActor(hammer8, 0,-10);*/



        Wrench wrench = new Wrench();
        scene.addActor(wrench,3,0);

        Backpack backpack = ripley.getBackpack();

       new When<>(()->ammo.intersects(ripley) ,new Invoke<>(() ->new Use<>(ammo).scheduleFor(ripley)
        )).scheduleFor(ripley);

        new When<>(()->energy.intersects(ripley) ,new Invoke<>(() ->new Use<>(energy).scheduleFor(ripley)
        )).scheduleFor(ripley);

        KeeperController keep = new KeeperController(ripley);
        scene.getInput().registerListener(keep);

        scene.getGame().getOverlay();

       backpack.add(hammer);
        backpack.add(fire);
        backpack.add(wrench);
        scene.getGame().pushActorContainer(ripley.getBackpack());
        backpack.shift();

    }
}
