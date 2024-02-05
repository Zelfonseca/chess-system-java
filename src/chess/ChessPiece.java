package chess;

import boardgame.Piece;
import boardgame.Position;
import boardgame.Board;

public abstract class ChessPiece extends Piece{
	
	//Atributos
	private Color color;


	//Construtores
	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}


	//Get and Set
	public Color getColor() {
		return color;
	}

	//Retirei o SET do Color pois não quero que a cor da peça seja modificada
	
	
	//Método===============================================
	protected boolean isThereOpponentPiece(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p != null && p.getColor() != color;
	}
	
	
	
	
	
	
	
	
	
	

}
