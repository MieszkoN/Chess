package com.niewiarowski.chess.board;

import com.niewiarowski.chess.pieces.Piece;

public final class OccupiedTile extends Tile {
    Piece pieceOnTile;

    OccupiedTile(int numberTileCoordinate, Piece pieceOnTile) {
        super(numberTileCoordinate);
        this.pieceOnTile = pieceOnTile;
    }

    @Override
    public boolean isOccupied() {
        return true;
    }

    @Override
    public Piece getPiece() {
        return this.pieceOnTile;
    }
}
