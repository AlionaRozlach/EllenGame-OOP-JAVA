package sk.tuke.kpi.oop.game.characters;

import java.util.ArrayList;

public class Health {

    @FunctionalInterface
    public interface ExhaustionEffect {
        void apply();
    }


    private int zac_health;
    private int max_health;
    private ArrayList<ExhaustionEffect> observer;



    public Health(int zaciatok, int max) {
        zac_health = zaciatok;
        this.max_health = max;
        observer=new ArrayList<>();
    }

    public Health(int max)
    {
        zac_health = max;
        this.max_health = max;
        observer=new ArrayList<>();
    }

    public void sendToObservers(){
        for (int i=0;i<observer.size();i++){
            observer.get(i).apply();
        }
    }

    public void onExhaustion(ExhaustionEffect effect){
        this.observer.add(effect);
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
        if(zac_health<0) return;

        zac_health-=modul;
        if(zac_health<0)
        {
            zac_health=0;
        }
        if (zac_health==0)
        {
            this.sendToObservers();
        }


    }

    public void exhaust()
    {
        if(zac_health == 0){
            this.sendToObservers();
        }
        zac_health = 0;
    }


}
