package chess.pieces;

import boardgame.Board;
import boardgame.Position;
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
		
		Position p = new Position(0,0);
		
		// movimentação da peça para cima
		p.setValues(position.getRow() - 1 , position.getColumn());
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat [p.getRow()] [p.getColumn()] = true;
			p.setRow(p.getRow() - 1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat [p.getRow()] [p.getColumn()] = true;
		}
		
		
		// movimentação da peça para esquerda 
		p.setValues(position.getRow() , position.getColumn() - 1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat [p.getRow()] [p.getColumn()] = true;
			p.setColumn(p.getColumn() - 1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat [p.getRow()] [p.getColumn()] = true;
		}
		
		
		// movimentação da peça para direita 
		p.setValues(position.getRow() , position.getColumn() + 1);		
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat [p.getRow()] [p.getColumn()] = true;
			p.setColumn(p.getColumn() + 1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat [p.getRow()] [p.getColumn()] = true;
		}
		
		
		// movimentação da peça para baixo
		p.setValues(position.getRow() + 1 , position.getColumn());	
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat [p.getRow()] [p.getColumn()] = true;
			p.setRow(p.getRow() + 1);
		}
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat [p.getRow()] [p.getColumn()] = true;
		}
		
				
		return mat;
	}
	
	
	//String========================
		@Override
		public String toString() {
			return "R";
	}
	

}
