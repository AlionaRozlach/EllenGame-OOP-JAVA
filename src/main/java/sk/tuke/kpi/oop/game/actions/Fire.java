package sk.tuke.kpi.oop.game.actions;

//import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.framework.actions.AbstractAction;
import sk.tuke.kpi.oop.game.Direction;
import sk.tuke.kpi.oop.game.characters.Armed;

public class Fire <A extends Armed> extends AbstractAction<A> {

    private A actor;
    @Override
    public void execute(float deltaTime) {

        if(actor!=null)
           {
                actor.getScene().addActor(actor.getFirearm().fire(),actor.getPosX()+10,actor.getPosY()+40);
               new Move<>(Direction.fromAngle(actor.getAnimation().getRotation()), 100).scheduleFor(actor.getFirearm().fire());
           }
        setDone(true);
    }

    @Override
    public void setActor(A actor) {
        this.actor = actor;
    }
}
