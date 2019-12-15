package sk.tuke.kpi.oop.game.items;


import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.characters.Armed;
import sk.tuke.kpi.oop.game.characters.Ripley;

public class Ammo  extends AbstractActor implements Usable<Armed> {

   public Ammo()
   {
       Animation ammic;
       ammic = new Animation("sprites/ammo.png", 16, 16);
       setAnimation(ammic);
   }



   /* @Override
    public void useWith(Ripley actor) {
       if(actor==null) return;
        Scene scene = getScene();
        if(actor.getAmmo()<500) {
            if (actor.getAmmo() < 450) {
                int naboj = actor.getAmmo();
                naboj += 50;
                actor.setAmmo(naboj);

                scene.removeActor(this);
            }
            if (actor.getAmmo() >= 450) {
                actor.setAmmo(500);
                scene.removeActor(this);
            }
        }
    }*/

    @Override
    public void useWith(Armed actor) {
        if(actor==null) return;
        Scene scene = getScene();
        if(scene !=null) {
            if (actor.getFirearm().getAmmo() < 450) {
                actor.getFirearm().reload(50);
                scene.removeActor(this);
            }
            else if (actor.getFirearm().getAmmo() >= 450) {
                actor.getFirearm().reload(500);
                scene.removeActor(this);
            }
        }
    }

    public Class<Armed> getUsingActorClass() {
        return Armed.class;
    }
}
