package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece{

	//Construtor==================================
	public King(Board board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}
	
	
	//Método==================================== chamado o método da classe PIECE
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean [getBoard().getRows()] [getBoard().getColumns()];
		return mat;
	}
	
	
	//String============================
	@Override
	public String toString() {
		return "K";
	}

}
