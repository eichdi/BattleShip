package ru.snaklab;

import javafx.scene.control.Tab;

import java.util.Scanner;

/**
 * Created by Samat Khairutdinov on 05.04.17 18:52.
 * BattleShip
 */
public class Game {
    Player firstPlayer;

    Player secondPlayer;

    Scanner scanner = new Scanner(System.in);


    public Table setUpTable(){
        Table table = new Table();
        int x;
        int y;
        int orientation;

        orientation = scanner.nextInt();
        for(int i = 0; i < 4;){
            System.out.println("Enter x");
            x = scanner.nextInt();
            System.out.println("Enter y");
            y = scanner.nextInt();
            System.out.println("Enter orientation 0 - vertical 1-horizontal");
            switch (orientation){
                case 0:{
                    if(table.setShip(1, x, y, ShipOrientation.VERTICAL)){
                        i++;
                    }
                    else {
                        System.out.println("Wrong x or y");
                    }
                    break;
                }
                case 1:{
                    if(table.setShip(1, x, y, ShipOrientation.HORIZONTAL)){
                        i++;
                    }
                    else {
                        System.out.println("Wrong x or y");
                    }
                    break;
                }
                default:{
                    System.out.println("Wrong orientation");
                }
            }
        }
        return table;
    }

    public void setUp(){
        String firstPlayerName;
        String secondPlayerName;

        System.out.println("Enter first Player name");
        firstPlayerName = scanner.next();
        Table firstTable = setUpTable();

        System.out.println("Enter second Player name");
        secondPlayerName = scanner.next();
        Table secondTable = setUpTable();

        this.firstPlayer = new Player(firstPlayerName, firstTable, secondTable);
        this.secondPlayer = new Player(secondPlayerName, secondTable, firstTable);
    }

    public void showTable(Table table){
        System.out.print(" ");
        for (int i = 0; i < Table.d; i++){
            System.out.print(i + " ");
        }

        System.out.print(" ");
        for(int i = 0; i < Table.d; i++){
            for(int j = 0; j < Table.d; j++){
                System.out.print(table.getPoints()[i][j] + " ");
            }
        }
    }

    public void playerTurn(Player player){

    }

    public void startGame(){

    }
}
