package sk.tuke.kpi.oop.game.openables;

public class LockedDoor extends Door {
   private boolean state = false;

    public boolean isLocked() {
        return state;
    }

    public void lock(){
        state = true;
        this.close();
    }

    public void unlock(){
        state= false;
        this.open();
    }
}
