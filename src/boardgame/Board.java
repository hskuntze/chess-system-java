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
		//aqui s�o instanciadas as POSI��ES do tabuleiro // todas elas NULL. OBS.: essas posi��es ainda n�o s�o as posi��es do XADREZ, s�o posi��es de matriz
		pieces = new Piece[rows][columns];
	}

	public Integer getRows() {
		return rows;
	}

	public Integer getColumns() {
		return columns;
	}
	
	//etapa 3.1 || m�todo para retornar uma pe�a em uma posi��o informada
	public Piece piece(int row, int column) {
		if(!positionExists(row, column)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[row][column];
	}
	
	
	//m�todo para retornar uma pe�a dada a posi��o em si
	public Piece piece(Position position) {
		if(!positionExists(position.getRow(), position.getColumn())) {
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	//m�todo para posicionar uma pe�a dada a pe�a e a posi��o
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("There is a piece here already" + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	//m�todo para verificar a exist�ncia de uma dada posi��o
	public boolean positionExists(int row, int column) {
		//linha (row) tem que ser maior que 0; e linha tem que ser menor que a quantidade de linhas do tabuleiro (rows) || mesmo para column.
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	public boolean positionExists(Position pos) {
		return positionExists(pos.getRow(), pos.getColumn());
	}
	
	//m�todo para verificar se h� uma pe�a posicionada em uma dada posi��o
	public boolean thereIsAPiece(Position pos) {
		if(!positionExists(pos.getRow(), pos.getColumn())) {
			throw new BoardException("Position not on the board");
		}
		return piece(pos) != null;
	}
}
