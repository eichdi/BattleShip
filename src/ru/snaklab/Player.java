package ru.snaklab;

/**
 * Created by Samat Khairutdinov on 05.04.17 18:52.
 * BattleShip
 */
public class Player {

    private String name;

    private int countTurns = 0;

    private Table playerTable;

    private Table enemyTable;

    public Player(String name, Table playerTable, Table enemyTable) {
        this.enemyTable = enemyTable;
        this.playerTable = playerTable;
        this.name = name;
    }

    public Table getPlayerTable() {
        return (Table) playerTable.clone();
    }

    public Table getEnemyTable() {
        Point[][] resultPoint = new Point[10][10];
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                if(enemyTable.getPoints()[i][j].isOpen()){
                    resultPoint[i][j] = (Point) enemyTable.getPoints()[i][j].clone();
                }
                else {
                    resultPoint[i][j] = Point.getUndeterminedPoint();
                }
            }
        }
        return new Table(resultPoint);
    }

    public boolean attack(int x, int y){
        return enemyTable.attack(x,y);
    }
}
