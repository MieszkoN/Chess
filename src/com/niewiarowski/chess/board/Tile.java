package com.niewiarowski.chess.board;

import com.niewiarowski.chess.pieces.Piece;

import java.util.*;

public abstract class Tile {
    //protected final char letterTileCoordinate;
    protected final int numberTileCoordinate;
    private static final Map<Integer, EmptyTile> EMPTY_TILE_MAP = createEmptyTileMap();

    Tile(int numberTileCoordinate) {
        this.numberTileCoordinate = numberTileCoordinate;
    }

    private static final Map<Integer, EmptyTile> createEmptyTileMap() {
        final Map<Integer, EmptyTile> hm = new HashMap<>();
        for(int i = 1; i <= 64; i++) {
            hm.put(i, new EmptyTile(i));
        }

        return hm;
    }

    public static Tile createTile(final int numberTileCoordinate, final Piece piece) {
        if(piece != null) {
            return new OccupiedTile(numberTileCoordinate, piece);
        } else {
            return EMPTY_TILE_MAP.get(numberTileCoordinate);
        }
    }

    public abstract boolean isOccupied();

    public abstract Piece getPiece();
}


