package boardgame;

//etapa 2.1
public class Piece {
	protected Position position;
	private Board board;
	
	public Piece(Board board) {
		this.board = board;
		//uma nova peça criada ainda não foi colocada no tabuleiro
		position = null;
	}
	
	//o tabuleiro associado a uma peça deve ser acessado somente pelo pacote "boardgame" e também pelas subclasses de peça
	protected Board getBoard() {
		return board;
	}

	
}
