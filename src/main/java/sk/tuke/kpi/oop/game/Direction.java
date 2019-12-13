package sk.tuke.kpi.oop.game;

public enum Direction {
    NORTH(0, 1), EAST(1, 0), WEST(-1, 0), SOUTH(0, -1), NONE(0, 0), NORTHWEST(-1, 1), NORTHEAST(1, 1), SOUTHEAST(1, -1), SOUTHWEST(-1, -1);
    private int dx;
    private int dy;
    private int x;
    private int y;



    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }


    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public float getAngle() {
       return  angleGet();
    }

    public float polovicaAnGet()
    {
        if(dx==-1 && dy==1) return 45;
       else if(dx==1 && dy==1) return 315;
       else if(dx==1 && dy==-1) return 225;
        else return 135;
    }
    public float angleGet()
    {
        if (dx == 0 && dy == 1) return 0;
       else  if (dx == -1 && dy == 0) return 90;
        else if (dx == 0 && dy == -1) return 180;
       else if(dx==1 && dy==0) return 270;
      else return polovicaAnGet();
    }

    public static Direction fromAngle(float angle) {
      return angleFrom(angle);
    }

    public static Direction angleFrom(float an)
    {
        if (an == 180.0) return SOUTH;
        else if (an == 270.0) return EAST;
        else if (an == 90.0) return WEST;
        else if(an == 0.0) return NORTH;
        else return anFRpolovica(an);
    }
    public static Direction anFRpolovica(float  an)
    {
        if(an == 315.0) return NORTHEAST;
    else if(an == 45.0) return NORTHWEST;
    else if(an ==225.0) return SOUTHEAST;
    else return SOUTHWEST;
    }
    public Direction combine(Direction other) {
         x = dx + other.dx;
         y = dy + other.dy;

        if (x > 1) x = 1;
        if (x < -1) x = -1;

        if (y > 1) y = 1;
        if (y < -1) y = -1;

        return normalDirection();
    }

    public Direction normalDirection()
    {
        if (x == 0 && y == 1) return NORTH;
        else if (x == 1 && y == 0) return EAST;
        else if (x == -1 && y == 0) return WEST;
        else if (x == 0 && y == -1) return SOUTH;
        else return normDirPolov();
    }

    public Direction normDirPolov()
    {
        if (x == -1 && y == 1) return NORTHWEST;
        else if (x == 1 && y == 1) return NORTHEAST;
        else if (x == 1 && y == -1) return SOUTHEAST;
        else if (x == -1 && y == -1) return SOUTHWEST;
        else return NONE;
    }
}
