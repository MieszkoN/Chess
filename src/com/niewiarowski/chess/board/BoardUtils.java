package com.niewiarowski.chess.board;

public class BoardUtils {
    public static final boolean [] FIRST_COLUMN = initColumn(0);
    public static final boolean [] SECOND_COLUMN = initColumn(1);
    public static final boolean [] SEVENTH_COLUMN = initColumn(6);
    public static final boolean [] EIGHTH_COLUMN = initColumn(7);

    public static final boolean[] SECOND_ROW = initRow(8);
    public static final boolean[] SEVENTH_ROW = initRow(48);

    private static boolean [] initColumn(int numberOfColumn) {
        final boolean[] column = new boolean[64];
        for(int i = numberOfColumn; i < 64; i+=8) {
            column[numberOfColumn] = true;
        }
        return column;
    }


    private static boolean[] initRow(int i) {
        final boolean[] row = new boolean[64];

        do {
            row[i] = true;
            i++;
        } while(i%8 != 0);

        return row;

    }

    public static boolean isValidCoordinate(int coordinate) {
        boolean check = false;
        if(coordinate >= 0 && coordinate < 64) {
            check = true;
        }
        return check;
    }
}
