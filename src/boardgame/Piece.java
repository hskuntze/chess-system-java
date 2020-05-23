package boardgame;

//etapa 2.1
public class Piece {
	protected Position position;
	private Board board;
	
	public Piece(Board board) {
		this.board = board;
		//uma nova pe�a criada ainda n�o foi colocada no tabuleiro
		position = null;
	}
	
	//o tabuleiro associado a uma pe�a deve ser acessado somente pelo pacote "boardgame" e tamb�m pelas subclasses de pe�a
	protected Board getBoard() {
		return board;
	}

	
}
