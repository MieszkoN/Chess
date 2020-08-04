package com.niewiarowski.chess.board;

import com.niewiarowski.chess.pieces.Piece;

public final class EmptyTile extends Tile {
    EmptyTile(char letterTileCoordinate, int numberTileCoordinate) {
        super(letterTileCoordinate, numberTileCoordinate);
    }

    @Override
    public boolean isOccupied() {
        return false;
    }

    @Override
    public Piece getPiece() {
        return null;
    }
}
