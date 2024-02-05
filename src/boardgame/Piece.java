package boardgame;

public abstract class Piece{
	
	
	//ATRIBUTO==========================
	protected Position position;
	private Board board;
	
	
	// CONSTRUTORES============================
	public Piece(Board board) {
		this.board = board;
		position = null;
	}
	

	
	//GET and SET=================================
	protected Board getBoard() {// somente classes dentro do mesmo pacote(BoardGame) e subclasses terão acesso
		return board;
	}
	
	// foi retirado o SET para não acontecer de manipular o tabuleiro


	
	//Métodos======================================
	public abstract boolean [][] possibleMoves();  //criada matrix booleana para movimentação das peças
	
	public boolean possibleMove(Position position) {		//esse método está utilizando o método abstrato acima
		return possibleMoves()[position.getRow()] [position.getColumn()];
	}
	
	
	public boolean isThereAnyPossibleMove() {
		boolean [][] mat = possibleMoves();
		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat.length; j++) {
				if (mat [i][j]) {
					return true;
				}
			}
		}
		return false;
	}
}
