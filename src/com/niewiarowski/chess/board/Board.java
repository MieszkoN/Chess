package com.niewiarowski.chess.board;

import com.niewiarowski.chess.ChessColor;
import com.niewiarowski.chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Board {
    private final List<Tile> gameBoard;

    public Board(final Builder builder) {
        this.gameBoard = createGameBoard(builder);
    }

    private static List<Tile> createGameBoard(final Builder builder) {
        final List<Tile> tiles = new ArrayList<>();
        for(int i = 0; i < 64; i++) {
            tiles.add(Tile.createTile(i, builder.boardConfiguration.get(i)));
        }
        return tiles;
    }

    public Tile getTile(final int tileCoordinate) {
        return null;
    }
    
    
    public static class Builder {
        Map<Integer, Piece> boardConfiguration;
        ChessColor nextMoveMaker;

        public Builder() {

        }

        public Builder setPiece(final Piece piece) {
            this.boardConfiguration.put(piece.getPiecePosition(), piece);
            return this;
        }

        public Builder setMoveMaker(ChessColor nextMoveMaker) {
            this.nextMoveMaker = nextMoveMaker;
            return this;
        }

        public Board build() {
            return new Board(this);
        }
    }
}
