package com.niewiarowski.chess.board;

import com.niewiarowski.chess.pieces.Piece;

public abstract class Move {

    final Board board;
    final Piece movedPiece;
    final int destination;

    public static final Move NULL_MOVE = new NullMove();

    public Move(final Board board, final Piece movedPiece, final int destination) {
        this.board = board;
        this.movedPiece = movedPiece;
        this.destination = destination;
    }

    @Override
    public int hashCode() {
        final int p = 31;
        int res = 1;

        res = p * res + this.destination;
        res = p * res + this.movedPiece.hashCode();

        return res;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if(!(obj instanceof Move)) {
            return false;
        }

        Move otherMove = (Move) obj;

        return getDestinationCoordinate() == otherMove.getDestinationCoordinate() && getMovedPiece().equals(otherMove.getMovedPiece());
    }

    public int getCurrentCoordinate() {
        return this.getMovedPiece().getPiecePosition();
    }


    public int getDestinationCoordinate() {
        return this.destination;
    }

    public Piece getMovedPiece() {
        return this.movedPiece;
    }

    public boolean isAttack() {
        return false;
    }

    public boolean isCastlingMove() {
        return false;
    }

    public Piece getAttackedPiece() {
        return null;
    }

    public Board execute() {
        final Board.Builder builder= new Board.Builder();

        for(Piece piece : this.board.currentPlayer().getCurrentPieces()) {
            if(!this.movedPiece.equals(piece)) {
                builder.setPiece(piece);
            }
        }

        for(Piece piece : this.board.currentPlayer().getOponent().getCurrentPieces()) {
            builder.setPiece(piece);
        }

        builder.setPiece(this.movedPiece.movePiece(this));
        builder.setMoveMaker(this.board.currentPlayer().getOponent().getColorOfPlayer());


        return builder.build();
    }


    public static final class NullMove extends Move {
        public NullMove() {
            super(null, null, -1);
        }

        @Override
        public Board execute() {
            throw new RuntimeException("cannot execute the null move!");
        }
    }

    public static class MoveFactory {

        private MoveFactory() {
            throw new RuntimeException("Not instantiable!");
        }

        public static Move createMove(final Board board, final int currentCoordinate, final int destinationCoordinate) {
            for(Move move : board.getAllLegalMoves()) {
                if(move.getCurrentCoordinate() == currentCoordinate && move.getDestinationCoordinate() == destinationCoordinate) {
                    return move;
                }
            }

            return NULL_MOVE;
        }
    }
}
