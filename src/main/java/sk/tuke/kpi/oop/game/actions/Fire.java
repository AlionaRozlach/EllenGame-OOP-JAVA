package sk.tuke.kpi.oop.game.actions;

//import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.framework.actions.AbstractAction;
import sk.tuke.kpi.oop.game.Direction;
import sk.tuke.kpi.oop.game.characters.Armed;
import sk.tuke.kpi.oop.game.weapons.Fireable;

public class Fire <A extends Armed> extends AbstractAction<A> {

    private A actor=getActor();
    @Override
    public void execute(float deltaTime) {

        if(actor!=null && actor.getFirearm().getAmmo()>0)
           {
               fireImplements();
           }
        setDone(true);
    }

    private void fireImplements()
    {
        Fireable fire = actor.getFirearm().fire();
        actor.getScene().addActor(fire,actor.getPosX()+10,actor.getPosY()+40);
        new Move<>(Direction.fromAngle(actor.getAnimation().getRotation()), 100).scheduleFor(fire);
    }
}
