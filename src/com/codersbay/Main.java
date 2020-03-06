package com.codersbay;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int maxRows = 102;            // +2 cause of the border
        int[][] field = new int[maxRows][maxRows];
        int[][] fieldNextGen = new int[maxRows][maxRows];

        int[][] moor = new int[3][3];
        int countNeighbours;


        // setRandomCells(fieldNextGen);

        setExploder(fieldNextGen);

        while (true) {

            makeNewGeneration(field, fieldNextGen);

            // scan the field
            for (int rowy = 1; rowy < field.length - 1; rowy++) {
                for (int columnx = 1; columnx < field[rowy].length - 1; columnx++) {

                    boolean cellisAlive = field[columnx][rowy] == 1;
                    boolean cellisDead = field[columnx][rowy] == 0;
                    countNeighbours = checkNeighbours(field, moor, rowy, columnx);

                    //---------------- if a cell is dead and has exactly 3 living neighbors, it will be born in the next generation 👶
                    //---------------------- if a cell is alive and has 2 or 3 neighbors, it stays alive 🤝‍
                    if (cellisDead && countNeighbours == 3 || cellisAlive && (countNeighbours == 2 || countNeighbours == 3)) {
                        fieldNextGen[columnx][rowy] = 1;
                    }
                    //---------------- is a cell alive and has less than 2 neighbors it dies of loneliness 😔
                    //------------------ is a cell alive and has more than 3 neighbors, it dies from overpopulation 💀
                    if (cellisAlive && countNeighbours < 2 || cellisAlive && countNeighbours > 3) {
                        fieldNextGen[columnx][rowy] = 0;
                    }
                }
            }
            printThisGeneration(field);
        }
    }

    public static void setRandomCells(int[][] fieldNextGen) {
        Random randomField = new Random();
        for (int rowy = 0; rowy < fieldNextGen.length; rowy++) {
            for (int columnx = 0; columnx < fieldNextGen[rowy].length; columnx++) {
                fieldNextGen[columnx][rowy] = randomField.nextInt(2);
            }
        }
    }

    private static void printThisGeneration(int[][] field) {
        //--------------------------------------------------------------Print to console
        for (int rowy = 1; rowy < field.length - 1; rowy++) {
            for (int columnx = 1; columnx < field[rowy].length - 1; columnx++) {
                if (field[columnx][rowy] == 1) {
                    System.out.print("# ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int checkNeighbours(int[][] field, int[][] moor, int rowy, int columnx) {
        int count = 0;
        for (int rowyMoor = 0; rowyMoor < moor.length; rowyMoor++) {
            for (int columnxMoor = 0; columnxMoor < moor[rowyMoor].length; columnxMoor++) {

                if (field[(columnx - 1) + columnxMoor][(rowy - 1) + rowyMoor] == 1) {
                    if (columnxMoor == 1 && rowyMoor == 1) {
                        continue;
                    }
                    count++;
                }
            }
        }
        return count;
    }

    private static void makeNewGeneration(int[][] field, int[][] fieldNextGen) {
        int temp;// copy Next generation to Array
        for (int rowy = 0; rowy < field.length; rowy++) {
            for (int columnx = 0; columnx < field[rowy].length; columnx++) {
                temp = fieldNextGen[columnx][rowy];
                field[columnx][rowy] = temp;
            }
        }
    }

    private static void setExploder(int[][] fieldNextGen) {
        fieldNextGen[48][48] = 1;
        fieldNextGen[48][49] = 1;
        fieldNextGen[48][50] = 1;
        fieldNextGen[48][51] = 1;
        fieldNextGen[48][52] = 1;
        fieldNextGen[50][48] = 1;
        fieldNextGen[50][52] = 1;
        fieldNextGen[52][48] = 1;
        fieldNextGen[52][49] = 1;
        fieldNextGen[52][50] = 1;
        fieldNextGen[52][51] = 1;
        fieldNextGen[52][52] = 1;
    }
}
