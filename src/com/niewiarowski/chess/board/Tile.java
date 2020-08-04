package com.niewiarowski.chess.board;

import com.niewiarowski.chess.pieces.Piece;

import java.util.*;

public abstract class Tile {
    protected final char letterTileCoordinate;
    protected final int numberTileCoordinate;

    private static final Map<Integer, EmptyTile> EMPTY_TILE_MAP = createEmptyTileMap();

    private static final Map<Integer, EmptyTile> createEmptyTileMap() {
        final Map<Integer, EmptyTile> hm = new HashMap<>();
        char letter = 'A';
        for(int i = 1; i <= 64; i++) {
            int mod = i%8;
            int res = i/8;
            switch(mod) {
                case 0:
                    letter = 'A';
                    break;
                case 1:
                    letter = 'B';
                    break;
                case 2:
                    letter = 'C';
                    break;
                case 3:
                    letter = 'D';
                    break;
                case 4:
                    letter = 'E';
                    break;
                case 5:
                    letter = 'F';
                    break;
                case 6:
                    letter = 'G';
                    break;
                case 7:
                    letter = 'H';
                    break;
                default:
                    break;
            }
            hm.put(i, new EmptyTile(letter, res));
        }

        return hm;
    }

    public static Tile createTile(final char letterTileCoordinate, final int numberTileCoordinate, final Piece piece) {
        if(piece != null) {
            return new OccupiedTile(letterTileCoordinate, numberTileCoordinate);
        } else {
            return EMPTY_TILE_MAP.get(numberTileCoordinate);
        }
    }

    Tile(char letterTileCoordinate, int numberTileCoordinate) {
        this.letterTileCoordinate = letterTileCoordinate;
        this.numberTileCoordinate = numberTileCoordinate;
    }

    public abstract boolean isOccupied();

    public abstract Piece getPiece();
}


