package chess;

import boardgame.Piece;
import boardgame.Position;
import boardgame.Board;

public abstract class ChessPiece extends Piece{
	
	//Atributos============================================================
	private Color color;
	private int moveCount;
	


	//Construtores========================================================
	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}


	//Get and Set===========================================================
	public Color getColor() {
		return color;
	}
	//Retirei o SET do Color pois não quero que a cor da peça seja modificada
	
	public int getMoveCount() {
		return moveCount;
	}
	
	//Métodos==========================================================================
	public ChessPosition getChessPosition() {
		 return ChessPosition.fromPosition(position);
	}

	public void increaseMoveCount() {
		moveCount++;
	}
	
	public void decreaseMoveCount() {
		moveCount--;
	}
	
	
	protected boolean isThereOpponentPiece(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p != null && p.getColor() != color;
	}
	//Método===============================================
	
	
	
	
	
	
	
	
	

}
