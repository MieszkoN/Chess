package com.niewiarowski.chess.pieces;

import com.niewiarowski.chess.ChessColor;
import com.niewiarowski.chess.board.Board;
import com.niewiarowski.chess.board.Move;

import java.util.List;

public abstract class Piece {

    protected final PieceType pieceType;
    protected final int piecePosition;
    protected final ChessColor pieceColor;
    protected final boolean isFirstMove;
    private final int cacheHashCode;

    Piece(final PieceType pieceType, final int piecePosition, final ChessColor pieceColor) {
        this.pieceType = pieceType;
        this.piecePosition = piecePosition;
        this.pieceColor = pieceColor;
        //TODO
        this.isFirstMove = false;
        this.cacheHashCode = hashCode();
    }

    public int getPiecePosition() {
        return this.piecePosition;
    }

    public ChessColor getPieceOfChessColor() {
        return this.pieceColor;
    }

    public boolean isFirstMove() {
        return this.isFirstMove;
    }

    public abstract List<Move> getLegalMoves(final Board board);

    public PieceType getPieceType() {
        return this.pieceType;
    }

    public abstract Piece movePiece(Move move);

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(!(obj instanceof Piece)) {
            return false;
        }

        final Piece other = (Piece) obj;

        return piecePosition == other.getPiecePosition() && pieceType == other.getPieceType() && pieceColor == other.getPieceOfChessColor() && isFirstMove == other.isFirstMove();
    }

    @Override
    public int hashCode() {
        int result = pieceType.hashCode();
        result = 31 * result * pieceColor.hashCode();
        result = 31 * result + piecePosition;
        result = 31 * result + (isFirstMove ? 1 : 0);

        return result;
    }

    public enum PieceType {

        PAWN("P") {
            @Override
            public boolean isKing() {
                return false;
            }
        },
        KNIGHT("K") {
            @Override
            public boolean isKing() {
                return false;
            }
        },
        BISHOP("B") {
            @Override
            public boolean isKing() {
                return false;
            }
        },
        ROOK("R") {
            @Override
            public boolean isKing() {
                return false;
            }
        },
        QUEEN("Q") {
            @Override
            public boolean isKing() {
                return false;
            }
        },
        KING("K") {
            @Override
            public boolean isKing() {
                return true;
            }
        };

        private final String pieceName;

        PieceType(final String pieceName) {
            this.pieceName = pieceName;
        }


        @Override
        public String toString() {
            return this.pieceName;
        }

        public abstract boolean isKing();
    }
}
