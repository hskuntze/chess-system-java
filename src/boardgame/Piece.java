package boardgame;

//etapa 2.1
public abstract class Piece {
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

	public abstract boolean possibleMoves()[][];
	
	//hook method
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	public boolean isThereAnyPossibleMove() {
		boolean[][] mat = possibleMoves();
		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat.length; j++) {
				if(mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
}
