package chess;

import boardgame.Position;

public class ChessPosition {
	
<<<<<<< HEAD
	
	//Atributos==================================
=======
	//atributos=============================
>>>>>>> b7b63a63af2ef5c715ad89754be5a4d6336867ae
	private char column;
	private int row;
	
	
<<<<<<< HEAD
	//Construtores==================================
	public ChessPosition(char column, int row) {
		if(column < 'A' || column > 'H' || row < 1 || row > 8) {
			throw new ChessException("Error instantiating ChessPosition. Vallid values are from A1 to H8");
=======
	//Construtor==================================
	public ChessPosition(char column, int row) {
		if(column < 'A' || column > 'H' || column < 1 || row > 8) {
			throw new ChessException("Error instatiating ChessPosition. Valid values are from A1 to H8");
>>>>>>> b7b63a63af2ef5c715ad89754be5a4d6336867ae
		}
		this.column = column;
		this.row = row;
	}

<<<<<<< HEAD
	//Get and Set=====================================

=======

	//Get and Set=======================
>>>>>>> b7b63a63af2ef5c715ad89754be5a4d6336867ae
	public char getColumn() {
		return column;
	}


	public int getRow() {
		return row;
	}
<<<<<<< HEAD

	
	
	//Método=====================================
	protected Position toPosition() {
		return new Position(8 - row, column - 'A');
	}
	
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char)('A' - position.getColumn()), 8 - position.getRow());
	}
	
	
	
=======
// foi apagado o SET da Column e Row, para não se permitir que sejam alteradas livremente
	
	//Método=========================================
	protected Position toPosition() {
		return new Position(8 - row , column - 'A'); 
	}
	
	
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char)('A' - position.getColumn()), 8 - position.getRow());
	}

	
	//toString
>>>>>>> b7b63a63af2ef5c715ad89754be5a4d6336867ae
	@Override
	public String toString() {
		return "" + column + row;
	}
	
<<<<<<< HEAD
	
	
	

=======
>>>>>>> b7b63a63af2ef5c715ad89754be5a4d6336867ae
}
