package ru.snaklab;

/**
 * Created by Samat Khairutdinov on 05.04.17 19:52.
 * BattleShip
 */
public class Point {

    private Ship ship = null;

    private boolean open = false;

    private PointStatus pointStatus = PointStatus.EMPTY;

    public static Point getUndeterminedPoint(){
        return new Point(null, false, PointStatus.UNDETERMINED);
    }

    public Point(){

    }

    private Point(Ship ship, boolean open, PointStatus pointStatus){
        this.ship = ship;
        this.open = open;
        this.pointStatus = pointStatus;
    }

    public PointStatus getPointStatus() {
        return pointStatus;
    }

    public boolean hasShip(){
        return ship != null;
    }

    public boolean isOpen(){
        return open;
    }

    public boolean setShip(Ship ship){
        if(ship == null){
            pointStatus = PointStatus.HAS_ALIVE_SHIP;
            this.ship = ship;
            return true;
        }
        return false;
    }

    public boolean attack(){
        if(!isOpen() && hasShip() && ship.isAlive()){
            ship.attack();
            if(ship.isAlive())
                pointStatus = PointStatus.HAS_WOUNDED_SHIP;
            else
                pointStatus = PointStatus.HAS_DEATH_SHIP;
            return true;
        }

        if(isOpen()){
            return true;
        }
        else{
            open = true;
        }
        return true;
    }

    @Override
    public Object clone(){
        return new Point((Ship) this.ship.clone(), this.open, this.pointStatus);
    }

}
