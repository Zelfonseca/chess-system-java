package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

// Nesta classe serão criadas as peças do xadres

public class Rook extends ChessPiece{

	//Construtor=======================
	public Rook(Board board, Color color) {
		super(board, color);
	}
	

	//Métodos======================= chamado o método da classe PIECE
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean [getBoard().getRows()] [getBoard().getColumns()];
		return mat;
	}
	
	
	//String========================
		@Override
		public String toString() {
			return "R";
	}
	

}
