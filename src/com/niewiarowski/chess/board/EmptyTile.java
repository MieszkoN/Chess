package com.niewiarowski.chess.board;

import com.niewiarowski.chess.pieces.Piece;

public final class EmptyTile extends Tile {
    EmptyTile(int numberTileCoordinate) {
        super(numberTileCoordinate);
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
