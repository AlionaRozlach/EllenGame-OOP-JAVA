package sk.tuke.kpi.oop.game.weapons;

public abstract class Firearm {
    private int min_ammo;
    private int max_ammo;

    public Firearm(int min,int max)
    {
        min_ammo=min;
        max_ammo=max;
    }

    public int getAmmo()
    {
        return this.min_ammo;
    }

    public void reload(int newAmmo)
    {
        if(min_ammo!=max_ammo)
        {
            min_ammo+=newAmmo;
            if(min_ammo>max_ammo)
            {
                min_ammo=max_ammo;
            }
        }
        else return;
    }


    protected abstract Fireable createBullet();

    public Fireable fire(){
        if (getAmmo() > 0){
            min_ammo --;
            return new Bullet();
        }
        return null;
    }
}
