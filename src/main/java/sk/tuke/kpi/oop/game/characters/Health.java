package sk.tuke.kpi.oop.game.characters;

public class Health {

    private int zac_health;
    private int max_health;

    public Health(int zaciatok, int max) {
        zac_health = zaciatok;
        this.max_health = max;
    }

    public Health(int max)
    {
        zac_health = max;
        this.max_health = max;
    }

    public int getValue()
    {
        return  zac_health;
    }

   public void refill(int amount)
    {
        zac_health+=amount;
        if(zac_health> max_health)
        {
            zac_health = max_health;
        }
    }

    public void restore()
    {
        zac_health=max_health;
    }

    public void drain(int amount)
    {
        int modul = Math.abs(amount);
        if(zac_health<=0) return;

        zac_health-=modul;
        if(zac_health<0)
        {
            zac_health=0;
        }
    }

    public void exhaust()
    {
        if(zac_health == 0){
            zac_health=0;
        }
        zac_health = 0;
    }
}
