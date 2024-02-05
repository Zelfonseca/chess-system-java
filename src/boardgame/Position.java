package boardgame;

public class Position {
	
	//ATRIBUTOS
	private int row;
	private int column;
	
	
	//CONSTRUTORES
	public Position() {
		
	}

	public Position(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}

	
	//GET AND SET
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}
	
	
	// MÉTODOS
	public void setValues(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	
	
	
	//To String 							para imprimir a posição das peças na tela
	@Override
	public String toString() {
		return row + " , " + column;
	}
	
	
	
	
	
	
	
	
	

}
