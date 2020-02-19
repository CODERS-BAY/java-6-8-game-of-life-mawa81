package com.codersbay;
/*



    ist eine Zelle am Leben und hat mehr als 3 Nachbarn, stirbt sie an Überbevölkerung 💀
*/

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int maxRows = 102;            // +2 cause of the border
        int[][] field = new int[maxRows][maxRows];
        int[][] fieldNextGen = new int[maxRows][maxRows];
        int[] startField = {maxRows / 2, maxRows / 2};
        boolean cellIsAlive = false;
        //field[50][50] = 1;
        int[][] moor = new int[3][3];
        int count = 0;
        int temp = 0;
        Random randomField = new Random();

        for (int column = 0; column < fieldNextGen.length; column++) {
            for (int row = 0; row < fieldNextGen[column].length; row++) {
                fieldNextGen[column][row] = 0;
            }
        }
        //random start population
        for (int columnMoor = 0; columnMoor < moor.length; columnMoor++) {
            for (int rowMoor = 0; rowMoor < moor[columnMoor].length; rowMoor++) {
                moor[columnMoor][rowMoor] = randomField.nextInt(2);
                fieldNextGen[maxRows / 2 + columnMoor][maxRows / 2 + rowMoor] = moor[columnMoor][rowMoor];
            }
        }

        while (true) {
            // copy Next generation to Array
            for (int column = 0; column < field.length; column++) {
                for (int row = 0; row < field[column].length; row++) {
                    temp = fieldNextGen[column][row];
                    field[column][row] = temp;
                    //System.out.print(temp);
                }
                // System.out.println();
            }
            // System.out.println();
            // scan the field
            for (int column = 1; column < field.length - 1; column++) {
                for (int row = 1; row < field[column].length - 1; row++) {
                    //----------------ist eine Zelle tot und hat genau 3 lebende Nachbarn, wird sie in der nächsten Generation geboren 👶
                    count = 0;
                    if (field[column][row] == 0) {

                        for (int columnMoor = 0; columnMoor < moor.length; columnMoor++) {
                            for (int rowMoor = 0; rowMoor < moor[columnMoor].length; rowMoor++) {
                                //moor[columnMoor][rowMoor] = randomField.nextInt(2);
                                if (field[(column - 1) + columnMoor][(row - 1) + rowMoor] == 1) {
                                    count++;
                                }
                            }
                        }
                        //System.out.println(count);
                        if (count == 3) {
                            fieldNextGen[column][row] = 1;
                            count = 0;
                        }
                    }

                    //----------------ist eine Zelle am Leben und hat weniger als 2 Nachbarn stirbt sie an Einsamkeit 😔
                    count = 0;
                    if (field[column][row] == 1) {

                        for (int columnMoor = 0; columnMoor < moor.length; columnMoor++) {
                            for (int rowMoor = 0; rowMoor < moor[columnMoor].length; rowMoor++) {
                                //moor[columnMoor][rowMoor] = randomField.nextInt(2);
                                if (field[(column - 1) + columnMoor][(row - 1) + rowMoor] == 1) {
                                    count++;
                                }
                            }
                        }
                        // System.out.println(count);
                        if (count <= 2) {
                            fieldNextGen[column][row] = 0;
                            count = 0;
                        }
                    }
                    //----------------------ist eine Zelle am Leben und hat 2 oder 3 Nachbarn, bleibt sie am Leben 🤝‍
                    count = 0;
                    if (field[column][row] == 1) {

                        for (int columnMoor = 0; columnMoor < moor.length; columnMoor++) {
                            for (int rowMoor = 0; rowMoor < moor[columnMoor].length; rowMoor++) {
                                //moor[columnMoor][rowMoor] = randomField.nextInt(2);
                                if (field[(column - 1) + columnMoor][(row - 1) + rowMoor] == 1) {
                                    count++;
                                }
                            }
                        }
                        // System.out.println(count);
                        if (count == 2 || count == 3) {
                            fieldNextGen[column][row] = 1;
                            count = 0;
                        }
                    }

                    //------------------ist eine Zelle am Leben und hat mehr als 3 Nachbarn, stirbt sie an Überbevölkerung 💀
                    count = 0;
                    if (field[column][row] == 1) {

                        for (int columnMoor = 0; columnMoor < moor.length; columnMoor++) {
                            for (int rowMoor = 0; rowMoor < moor[columnMoor].length; rowMoor++) {
                                //moor[columnMoor][rowMoor] = randomField.nextInt(2);
                                if (field[(column - 1) + columnMoor][(row - 1) + rowMoor] == 1) {
                                    count++;
                                }
                            }
                        }
                        // System.out.println(count);
                        if (count > 3) {
                            fieldNextGen[column][row] = 0;
                            count = 0;
                        }
                    }
                }

            }

            //--------------------------------------------------------------Print to console
            for (int column = 1; column < field.length - 1; column++) {
                for (int row = 1; row < field[column].length - 1; row++) {
                    if (field[column][row] == 1) {
                        System.out.print("# ");
                    } else {
                        System.out.print(". ");
                    }
                }
                System.out.println();
            }
            System.out.println();

        }
    }
}
