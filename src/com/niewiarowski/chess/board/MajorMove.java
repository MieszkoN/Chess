package com.niewiarowski.chess.board;

import com.niewiarowski.chess.pieces.Piece;

public final class MajorMove extends Move{

    public MajorMove(Board board, Piece movedPiece, int destination) {
        super(board, movedPiece, destination);
    }

    @Override
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
}
