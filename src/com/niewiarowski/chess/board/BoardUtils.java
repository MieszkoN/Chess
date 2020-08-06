package com.niewiarowski.chess.board;

public class BoardUtils {
    public static final boolean [] FIRST_COLUMN = null;
    public static final boolean [] SECOND_COLUMN = null;
    public static final boolean [] SEVENTH_COLUMN = null;
    public static final boolean [] EIGHTH_COLUMN = null;


    public static boolean isValidCoordinate(int coordinate) {
        boolean check = false;
        if(coordinate >= 0 && coordinate < 64) {
            check = true;
        }
        return check;
    }
}
