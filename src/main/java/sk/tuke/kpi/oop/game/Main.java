package sk.tuke.kpi.oop.game;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.*;
import sk.tuke.kpi.gamelib.framework.Scenario;
import sk.tuke.kpi.oop.game.characters.Ripley;
import sk.tuke.kpi.oop.game.scenarios.EscapeRoom;
import sk.tuke.kpi.oop.game.scenarios.FirstSteps;
import sk.tuke.kpi.oop.game.scenarios.MissionImpossible;

public class Main {

    public static void main(String[] args) {

      WindowSetup windowSetup = new WindowSetup("Project Ellen", 800, 600);
        Game game = new GameApplication(windowSetup);
        Scene scene = new World("world","maps/escape-room.tmx",new EscapeRoom.Factory());
        game.addScene(scene);


       FirstSteps scenario = new FirstSteps();
        scene.addListener(scenario);


        MissionImpossible miss = new MissionImpossible();
        scene.addListener(miss);

        EscapeRoom esc = new EscapeRoom();
        scene.addListener(esc);



        game.start();
        game.getInput().onKeyPressed(Input.Key.ESCAPE, () -> game.stop());
    }
}

