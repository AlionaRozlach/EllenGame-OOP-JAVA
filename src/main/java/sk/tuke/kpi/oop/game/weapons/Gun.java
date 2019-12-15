package sk.tuke.kpi.oop.game.weapons;


public class Gun extends Firearm {

    public Gun(int min_ammo, int max_Ammo) {
        super(min_ammo, max_Ammo);
    }

    @Override
    protected Fireable createBullet() {
        return new Bullet();
    }


}
