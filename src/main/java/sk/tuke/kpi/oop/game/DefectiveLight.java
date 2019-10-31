package sk.tuke.kpi.oop.game;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Disposable;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.framework.actions.Loop;



public class DefectiveLight extends Light{

    private Disposable disposable;
    public DefectiveLight()
    {
        super();
    }

    public void defectiveLight()
    {
        int rand =(int)(Math.random()*20+1);
        if(rand == 1)
        {
            this.toggle();
        }
    }

    @Override

    public void addedToScene( @NotNull Scene scene)
    {
        if(scene == null) return;
        super.addedToScene(scene);
        new Loop<>(new Invoke<>(this::defectiveLight)).scheduleFor(this);
    }

}
