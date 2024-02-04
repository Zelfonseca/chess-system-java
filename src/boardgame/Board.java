package boardgame;

public class Board {
	
	//Atributos===================================================
	private int rows;
	private int columns;
	private Piece [][] pieces;
	
	
	//Construtores===============================================
	public Board(int rows, int columns) {
		if(rows < 1 || columns < 1) {
			throw new BoardException("Error creating board: there must bu at least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	//Get and Set===================================================
	public int getRows() {
		return rows;
	}

//	public void setRows(int rows) { 		Retira-se o setRows para não permitir que seja alterada a quantidade de linhas
//		this.rows = rows;
//	}

	public int getColumns() {
		return columns;
	}

//	public void setColumns(int columns) {		Retira-se o setColumns para não permitir que seja alterada a quantidade de colunas
//		this.columns = columns;
//	}
	
	
	//Métodos===============================================================================================================
	public Piece piece(int row , int column) {
		if(!positionExists(row, column)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[row][column];
	}
	
	
	public Piece piece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()] [position.getColumn()];
	}

	
	//método para posicionar a peça no tabuleiro
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position " + position);
		}
		pieces [position.getRow()] [position.getColumn()] = piece;
		piece.position = position;
	}
	
	//método para remover a peça do tabuleiro==================
	public Piece removePiece(Position position) {
	if(!positionExists(position)) {
		throw new BoardException("Position not on the board");
		}
		if(piece(position) == null){
			return null;
		}
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()] [position.getColumn()] = null;
		return aux;
	}
	
	
	
	
	private boolean positionExists(int row, int column) {		// esse é um método auxiliar para verificação do tamanho do tabuleiro para as posições
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn()); 
	}
	
	
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return piece(position) != null;
	}
	
	
	
	
	
	
	
	
	
	
}
