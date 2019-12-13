package sk.tuke.kpi.oop.game;

public enum Direction {
    NORTH(0,1),EAST(1,0),WEST(-1,0),SOUTH(0,-1),NONE(0,0),NORTHWEST(-1,1),NORTHEAST(1,1),SOUTHEAST(1,-1),SOUTHWEST(-1,-1);
    private int dx;
    private int dy;


   Direction(int dx, int dy)
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

    public static Direction fromAngle(float angle)
    {
        if(angle == 180.0) return SOUTH;
        else if(angle == 270.0) return EAST;
       else if(angle == 90.0) return WEST;
       else return NORTH;
    }

    public Direction combine(Direction other)
    {
        int x = dx+other.dx;
        int y = dy+other.dy;

        if(x>1) x=1;
        if(x<-1) x=-1;

        if(y>1) y=1;
        if(y<-1) y=-1;

        if(x==0 && y==1) return NORTH;
        else if(x==1 && y==0) return EAST;
        else if(x==-1 && y==0) return WEST;
        else if(x==0 && y==-1) return SOUTH;
        else if(x==-1 && y==1) return NORTHWEST;
        else if(x==1 && y==1) return NORTHEAST;
        else if(x==1 && y==-1) return SOUTHEAST;
        else if(x==-1 && y==-1) return SOUTHWEST;

        else return NONE;
    }

}
