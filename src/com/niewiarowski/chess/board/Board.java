package com.niewiarowski.chess.board;

import com.niewiarowski.chess.ChessColor;
import com.niewiarowski.chess.pieces.*;
import com.niewiarowski.chess.player.BlackPlayer;
import com.niewiarowski.chess.player.WhitePlayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private final List<Tile> gameBoard;
    private final List<Piece> whitePieces;
    private final List<Piece> blackPieces;

    private final WhitePlayer whitePlayer;
    private final BlackPlayer blackPlayer;

    public Board(final Builder builder) {
        this.gameBoard = createGameBoard(builder);
        this.whitePieces = getCurrentPieces(this.gameBoard, ChessColor.WHITE);
        this.blackPieces = getCurrentPieces(this.gameBoard, ChessColor.BLACK);

        final List<Move> whiteLegalMoves = getLegalMoves(this.whitePieces);
        final List<Move> blackLegalMoves = getLegalMoves(this.blackPieces);

        this.whitePlayer = new WhitePlayer(this, whiteLegalMoves, blackLegalMoves);
        this.blackPlayer = new BlackPlayer(this, whiteLegalMoves, blackLegalMoves);

    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        for(int i = 0; i < 64; i++) {
            final String tileString = printBoard(this.gameBoard.get(i));
            builder.append(String.format("%3s", tileString));
            if((i+1) % 8 == 0) {
                builder.append("\n");
            }
        }

        return builder.toString();
    }

    private static String printBoard(Tile tile) {
        return tile.toString();
    }



    private List<Move> getLegalMoves(final List<Piece> pieces) {
        final List <Move> legalMoves = new ArrayList<>();
        for(final Piece piece : pieces) {
            legalMoves.addAll(piece.getLegalMoves(this));
        }
        return legalMoves;
    }

    private List<Piece> getCurrentPieces(List<Tile> gb, ChessColor col) {
        final List<Piece> currentPieces = new ArrayList<>();
        for(final Tile tile : gb) {
            if(tile.isOccupied()) {
                Piece piece = tile.getPiece();
                if(piece.getPieceOfChessColor() == col) {
                    currentPieces.add(piece);
                }
            }
        }
        return currentPieces;
    }

    private static List<Tile> createGameBoard(final Builder builder) {
        final List<Tile> tiles = new ArrayList<>();
        for(int i = 0; i < 64; i++) {
            tiles.add(Tile.createTile(i, builder.boardConfiguration.get(i)));
        }
        return tiles;
    }

    public static Board createStandardBoard() {
        final Builder builder = new Builder();
        //Black player
        builder.setPiece(new Rook(0, ChessColor.BLACK));
        builder.setPiece(new Knight(1, ChessColor.BLACK));
        builder.setPiece(new Bishop(2, ChessColor.BLACK));
        builder.setPiece(new Queen(3, ChessColor.BLACK));
        builder.setPiece(new King(4, ChessColor.BLACK));
        builder.setPiece(new Bishop(5, ChessColor.BLACK));
        builder.setPiece(new Knight(6, ChessColor.BLACK));
        builder.setPiece(new Rook(7, ChessColor.BLACK));

        //Pawns
        for(int i = 8; i < 16; i++) {
            builder.setPiece(new Pawn(i, ChessColor.BLACK));
        }

        //White player
        //Pawns
        for(int i = 48; i < 56; i++) {
            builder.setPiece(new Pawn(i, ChessColor.WHITE));
        }
        builder.setPiece(new Rook(56, ChessColor.WHITE));
        builder.setPiece(new Knight(57, ChessColor.WHITE));
        builder.setPiece(new Bishop(58, ChessColor.WHITE));
        builder.setPiece(new Queen(59, ChessColor.WHITE));
        builder.setPiece(new King(60, ChessColor.WHITE));
        builder.setPiece(new Bishop(61, ChessColor.WHITE));
        builder.setPiece(new Knight(62, ChessColor.WHITE));
        builder.setPiece(new Rook(63, ChessColor.WHITE));


        return builder.build();

    }

    public Tile getTile(final int tileCoordinate) {
        return gameBoard.get(tileCoordinate);
    }

    public List<Piece> getWhitePieces() {
        return this.whitePieces;
    }

    public List<Piece> getBlackPieces() {
        return this.blackPieces;
    }


    public static class Builder {
        Map<Integer, Piece> boardConfiguration;
        ChessColor nextMoveMaker;

        public Builder() {
            this.boardConfiguration = new HashMap<>();
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
