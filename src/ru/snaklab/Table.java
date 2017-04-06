package ru.snaklab;

/**
 * Created by Samat Khairutdinov on 05.04.17 18:54.
 * BattleShip
 */
public class Table implements Cloneable {

    public Table(Point[][] points) {
        this.points = points;
    }

    public Table() {
    }

    public static boolean correctCord(int x, int y){
        return x >= 0 && x <= 10 && y >= 0 && y<= 10;
    }

    public Point[][] getPoints() {
        return points;
    }

    private Point[][] points = new Point[10][10];

    private int getLeftBorder(int y){
        if(y == 0)
            return y;
        else
            return y-1;
    }
    private int getRightBorder(int y){
        if(y == 10)
            return y;
        else
            return y+1;
    }
    private int getUpBorder(int x){
        if(x == 0)
            return x;
        else
            return x-1;
    }
    private int getDownBorder(int x){
        if(x == 10)
            return x;
        else
            return x+1;
    }

    private boolean checkPoint(int x, int y){
        for(int i = getUpBorder(x); i <= getDownBorder(x); i++){
            for(int j = getLeftBorder(y); i <= getRightBorder(y); i++){
                if(points[i][j].hasShip())
                    return false;
            }
        }
        return true;
    }

    public boolean setShip(int xp, int x, int y, ShipOrientation shipOrientation){
        if(correctCord(x,y)){
            switch (shipOrientation){
                case HORIZONTAL:{
                    for(int i = 0; i < xp; i++){
                        if(!checkPoint(x,y+i))
                            return false;
                    }
                    Ship ship = new Ship(xp);
                    for(int i = 0; i < xp; i++){
                        points[x][y+i].setShip(ship);
                    }
                    break;
                }
                case VERTICAL:{
                    for(int i = 0; i < xp; i++){
                        if(!checkPoint(x+i,y))
                            return false;
                    }
                    Ship ship = new Ship(xp);
                    for(int i = 0; i < xp; i++){
                        points[x+i][y].setShip(ship);
                    }
                    break;
                }
            }
        }
        return false;
    }

    public boolean attack(int x, int y){
        if(correctCord(x,y)){
            return points[x][y].attack();
        }
        return false;
    }

    @Override
    public Object clone(){
        return new Table(this.points.clone());
    }
}
