package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMath;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
	
	//Atributos===================================
	private ChessMath chessMath;
	
	

	// Construtor==================================
	public King(Board board, Color color, ChessMath chessMath) {
		super(board, color);
		this.chessMath = chessMath;
	}

	// Método==================================== chamado o método da classe PIECE e
	// criando movimentos da peça

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);

		// movimentação da peça para cima
		p.setValues(position.getRow() - 1, position.getColumn());
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// movimentação da peça para baixo
		p.setValues(position.getRow() + 1, position.getColumn());
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// movimentação da peça para esquerda
		p.setValues(position.getRow(), position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// movimentação da peça para diagonal superior lado esquerdo
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// movimentação da peça para diagonal inferior lado esquerdo
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// movimentação da peça para direita
		p.setValues(position.getRow(), position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// movimentação da peça para diagonal superior lado direito
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// movimentação da peça para diagonal inferior lado direito
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		
		//Movimento especial "ROCK"
		if(getMoveCount() == 0 && !chessMath.getCheck()) {
			//test de ROCK com a torre do lado do rei(direita)
			Position posT1 = new Position (position.getRow(), position.getColumn() + 3);
			if(testRookCastling(posT1)) {
				Position p1 = new Position (position.getRow(), position.getColumn() + 1);
				Position p2 = new Position (position.getRow(), position.getColumn() + 2);
				if(getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
					mat [position.getRow()] [position.getColumn() +2 ] = true;
				}
			}
			//test de ROCK com a torre do lado da rainha(esquerda)
			Position posT2 = new Position (position.getRow(), position.getColumn() - 4);
			if(testRookCastling(posT2)) {
				Position p1 = new Position (position.getRow(), position.getColumn() - 1);
				Position p2 = new Position (position.getRow(), position.getColumn() - 2);
				Position p3 = new Position (position.getRow(), position.getColumn() - 3);
				if(getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
					mat [position.getRow()] [position.getColumn() -2 ] = true;
				}
			}
		}
		return mat;
	}

	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}
	
	
	private boolean testRookCastling(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
	}
	
	
	// Método====================================
	
	

	// String============================
	@Override
	public String toString() {
		return "K";
	}

}
