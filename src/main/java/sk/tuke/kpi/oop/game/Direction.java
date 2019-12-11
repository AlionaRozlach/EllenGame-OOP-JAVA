package sk.tuke.kpi.oop.game;

public enum Direction {
    NORTH(0,1),EAST(1,0),WEST(-1,0),SOUTH(0,-1);
    private int dx;
    private int dy;

    Direction(int dx,int dy)
    {
        this.dx = dx;
        this.dy = dy;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

   public float getAngle()
    {
        if(dx == 0 && dy ==1) return 0;
        else if(dx == -1 && dy ==0) return 90;
        else if(dx == 0 && dy == -1) return 180;
        else return 270;
    }
}
