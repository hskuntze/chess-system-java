package boardgame;

//etapa 2.2
public class Board {
	private Integer rows;
	private Integer columns;
	private Piece[][] pieces;
	
	public Board(Integer rows, Integer columns) {
		if(rows < 1 || columns < 1) {
			throw new BoardException("Error: there must be at least 1 row and/or 1 column");
		}
		
		this.rows = rows;
		this.columns = columns;
		//aqui são instanciadas as POSIÇÕES do tabuleiro // todas elas NULL. OBS.: essas posições ainda não são as posições do XADREZ, são posições de matriz
		pieces = new Piece[rows][columns];
	}

	public Integer getRows() {
		return rows;
	}

	public Integer getColumns() {
		return columns;
	}
	
	//etapa 3.1 || método para retornar uma peça em uma posição informada
	public Piece piece(int row, int column) {
		if(!positionExists(row, column)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[row][column];
	}
	
	
	//método para retornar uma peça dada a posição em si
	public Piece piece(Position position) {
		if(!positionExists(position.getRow(), position.getColumn())) {
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	//método para posicionar uma peça dada a peça e a posição
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("There is a piece here already" + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	//método para verificar a existência de uma dada posição
	public boolean positionExists(int row, int column) {
		//linha (row) tem que ser maior que 0; e linha tem que ser menor que a quantidade de linhas do tabuleiro (rows) || mesmo para column.
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	public boolean positionExists(Position pos) {
		return positionExists(pos.getRow(), pos.getColumn());
	}
	
	//método para verificar se há uma peça posicionada em uma dada posição
	public boolean thereIsAPiece(Position pos) {
		if(!positionExists(pos.getRow(), pos.getColumn())) {
			throw new BoardException("Position not on the board");
		}
		return piece(pos) != null;
	}
}
