package ru.snaklab;

import java.util.Map;

/**
 * Created by Samat Khairutdinov on 05.04.17 18:55.
 * BattleShip
 */
public class Ship {
    private int xp;

    public boolean isAlive(){
        return xp > 0;
    }

    public void attack(){
        if(isAlive())
            xp--;
    }

    public Ship (int xp) {
        this.xp = xp;
    }

    @Override
    public Object clone(){
        return new Ship(this.xp);
    }
}
