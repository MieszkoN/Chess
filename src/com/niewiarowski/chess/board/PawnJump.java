package com.niewiarowski.chess.board;

import com.niewiarowski.chess.pieces.Pawn;
import com.niewiarowski.chess.pieces.Piece;

public class PawnJump extends Move{
    public PawnJump(Board board, Piece movedPiece, int destination, Piece attackedPiece) {
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

        final Pawn movedPawn = (Pawn)this.movedPiece.movePiece(this);
        builder.setPiece(movedPawn);
        builder.setEnPassantPawn(movedPawn);


        builder.setMoveMaker(this.board.currentPlayer().getOponent().getColorOfPlayer());


        return builder.build();
    }
}
