package com.codersbay;

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

        for (int rowy = 0; rowy < fieldNextGen.length; rowy++) {
            for (int columnx = 0; columnx < fieldNextGen[rowy].length; columnx++) {
                fieldNextGen[columnx][rowy] = 0;
            }
        }
        //random start population
  /*      for (int rowyMoor = 0; rowyMoor < moor.length; rowyMoor++) {
            for (int rowMoor = 0; rowMoor < moor[rowyMoor].length; rowMoor++) {
                moor[rowMoor][rowyMoor] = randomField.nextInt(2);
                fieldNextGen[maxRows / 2 + rowMoor][maxRows / 2 + rowyMoor] = moor[rowMoor][rowyMoor];
            }
        } */


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

        while (true) {
            // copy Next generation to Array
            for (int rowy = 0; rowy < field.length; rowy++) {
                for (int columnx = 0; columnx < field[rowy].length; columnx++) {
                    temp = fieldNextGen[columnx][rowy];
                    field[columnx][rowy] = temp;
                }
            }

            // scan the field
            for (int rowy = 1; rowy < field.length - 1; rowy++) {
                for (int columnx = 1; columnx < field[rowy].length - 1; columnx++) {
                    //----------------ist eine Zelle tot und hat genau 3 lebende Nachbarn, wird sie in der nächsten Generation geboren 👶
                    count = 0;
                    if (field[columnx][rowy] == 0) {

                        for (int rowyMoor = 0; rowyMoor < moor.length; rowyMoor++) {
                            for (int columnxMoor = 0; columnxMoor < moor[rowyMoor].length; columnxMoor++) {
                                //moor[rowyMoor][rowMoor] = randomField.nextInt(2);
                                if (field[(columnx - 1) + columnxMoor][(rowy - 1) + rowyMoor] == 1) {
                                    if (columnxMoor == 1 && rowyMoor == 1) {
                                        continue;
                                    }
                                    count++;
                                }
                            }
                        }
                        //System.out.println(count);
                        if (count == 3) {
                            fieldNextGen[columnx][rowy] = 1;
                        }
                    }

                    //----------------ist eine Zelle am Leben und hat weniger als 2 Nachbarn stirbt sie an Einsamkeit 😔
                    count = 0;
                    if (field[columnx][rowy] == 1) {

                        for (int rowyMoor = 0; rowyMoor < moor.length; rowyMoor++) {
                            for (int columnxMoor = 0; columnxMoor < moor[rowyMoor].length; columnxMoor++) {
                                //moor[rowyMoor][rowMoor] = randomField.nextInt(2);
                                if (field[(columnx - 1) + columnxMoor][(rowy - 1) + rowyMoor] == 1) {
                                    if (columnxMoor == 1 && rowyMoor == 1) {
                                        continue;
                                    }
                                    count++;
                                }
                            }
                        }
                        // System.out.println(count);
                        if (count < 2) {
                            fieldNextGen[columnx][rowy] = 0;
                        }
                    }
                    //----------------------ist eine Zelle am Leben und hat 2 oder 3 Nachbarn, bleibt sie am Leben 🤝‍
                    count = 0;
                    if (field[columnx][rowy] == 1) {

                        for (int rowyMoor = 0; rowyMoor < moor.length; rowyMoor++) {
                            for (int columnxMoor = 0; columnxMoor < moor[rowyMoor].length; columnxMoor++) {
                                //moor[rowyMoor][rowMoor] = randomField.nextInt(2);
                                if (field[(columnx - 1) + columnxMoor][(rowy - 1) + rowyMoor] == 1) {
                                    if (columnxMoor == 1 && rowyMoor == 1) {
                                        continue;
                                    }
                                    count++;
                                }
                            }
                        }
                        // System.out.println(count);
                        if (count == 2 || count == 3) {
                            fieldNextGen[columnx][rowy] = 1;
                        }
                    }

                    //------------------ist eine Zelle am Leben und hat mehr als 3 Nachbarn, stirbt sie an Überbevölkerung 💀
                    count = 0;
                    if (field[columnx][rowy] == 1) {

                        for (int rowyMoor = 0; rowyMoor < moor.length; rowyMoor++) {
                            for (int columnxMoor = 0; columnxMoor < moor[rowyMoor].length; columnxMoor++) {
                                //moor[rowyMoor][rowMoor] = randomField.nextInt(2);
                                if (field[(columnx - 1) + columnxMoor][(rowy - 1) + rowyMoor] == 1) {
                                    if (columnxMoor == 1 && rowyMoor == 1) {
                                        continue;
                                    }
                                    count++;
                                }
                            }
                        }
                        // System.out.println(count);
                        if (count > 3) {
                            fieldNextGen[columnx][rowy] = 0;
                        }
                    }
                }

            }

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
    }
}
