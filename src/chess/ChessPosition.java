package chess;

import boardgame.Position;

public class ChessPosition {
	

	
	//Atributos=========================================
	private char column;
	private int row;
	
	

	//Construtores==================================
	public ChessPosition(char column, int row) {
		if(column < 'A' || column > 'H' || column < 1 || row > 8) {
			throw new ChessException("Error instatiating ChessPosition. Valid values are from A1 to H8");

		}
		this.column = column;
		this.row = row;
	}


	//Get and Set=====================================
	public char getColumn() {
		return column;
	}


	public int getRow() {
		return row;
	}
	// foi apagado o SET da Column e Row, para não se permitir que sejam alteradas livremente

	
	
	//Método=====================================
	protected Position toPosition() {
		return new Position(8 - row, column - 'A');
	}
	
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char)('A' - position.getColumn()), 8 - position.getRow());
	}

	
	//toString

	@Override
	public String toString() {
		return "" + column + row;
	}
	

	
	
	


}
