package boardgame;

public class Piece{
	
	
	//ATRIBUTO
	protected Position position;
	private Board board;
	
	
	// CONSTRUTORES
	public Piece() {
		
	}

	public Piece(Position position) {
		super();
		this.position = position;
		position = null;
	}

	
	//GET and SET
	protected Board getBoard() {// somente classes dentro do mesmo pacote(BoardGame) e subclasses terão acesso
		return board;
	}
// foi retirado o SET para não acontecer de manipular o tabuleiro
	
	
	
	
	
	
	
	
	

}
