package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMath;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {
	
	
	
	//Atributos===============================
	private ChessMath chessMath;
	

	// Construtor==================================
	public Pawn(Board board, Color color, ChessMath chessMath) {
		super(board, color);
		this.chessMath = chessMath;
	}

	// Método========================================
	@Override
	public boolean[][] possibleMoves() {

		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);

		// regra para peça branca(estando ela embaixo) pois o PEÃO só poderá se movimentando para cima somente uma casa
		
		//Regra para movimentação de uma casa
		if (getColor() == Color.WHITE) {
			p.setValues(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			//Regra para movimentação de duas casas pela primeira jogada com a peça, estando ela na posição inicial
			p.setValues(position.getRow() - 2, position.getColumn());
			Position p2 = new Position(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			// movimentação da peça para diagonal superior lado esquerdo
			p.setValues(position.getRow() - 1, position.getColumn() - 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			// movimentação da peça para diagonal superior lado direito
			p.setValues(position.getRow() - 1, position.getColumn() + 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			//Movimento especial "enPassant" das peças BRANCAS=======================================
			if(position.getRow() == 3) {
				Position left = new Position(position.getRow(), position.getColumn() -1);
				if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMath.getEnPassantVulnerable()) {
					mat[left.getRow() - 1][left.getColumn()] = true;
				}
				Position right = new Position(position.getRow(), position.getColumn() +1);
				if(getBoard().positionExists(left) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMath.getEnPassantVulnerable()) {
					mat[right.getRow() - 1][right.getColumn()] = true;
				}
			}
			
		}
		// regra para peça PRETA(estando ela em cima) pois o PEÃO só poderá se movimentar para baixo
		else {
			// movimentando para baixo somente uma casa
				p.setValues(position.getRow() + 1, position.getColumn());
				if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				// movimentando para baixo duas casas pela primeira jogada com a peça, estando ela na posição inicial
				p.setValues(position.getRow() + 2, position.getColumn());
				Position p2 = new Position(position.getRow() + 1, position.getColumn());
				if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				// movimentação da peça para diagonal inferior lado esquerdo
				p.setValues(position.getRow() + 1, position.getColumn() - 1);
				if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				// movimentação da peça para diagonal inferior lado direito
				p.setValues(position.getRow() + 1, position.getColumn() + 1);
				if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//Movimento especial "enPassant" das peças PRETAS=======================================
				if(position.getRow() == 4) {
					Position left = new Position(position.getRow(), position.getColumn() -1);
					if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMath.getEnPassantVulnerable()) {
						mat[left.getRow() + 1][left.getColumn()] = true;
					}
					Position right = new Position(position.getRow(), position.getColumn() +1);
					if(getBoard().positionExists(left) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMath.getEnPassantVulnerable()) {
						mat[right.getRow() + 1][right.getColumn()] = true;
					}
				}
			}   
		
		return mat;
	}

	// String============================
		@Override
		public String toString() {
			return "P";
		}
	
	
}
