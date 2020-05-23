package chess;

import boardgame.Position;


/* Considera��es:
 * 
 * Uma posi��o no XADREZ � diferente da forma como tratamos arrays em programa��o -
 * mesmo sabendo que um tabuleiro � uma matriz, temos de respeitar as regras de ne-
 * g�cios e implementar a solu��o devida. Uma posi��o no xadrez � dada como uma le-
 * tra e um n�mero, sendo a letra o eixo das abcissas (X) e o n�mero o eixo das or-
 * denadas (Y), ou, se preferir, letra equivale a 'i' e n�mero a 'j'.
 */
public class ChessPosition {
	private char column;
	private int row;
	
	public ChessPosition(char column, int row) {
		if(column < 'a' || column > 'h' || row < 1 || row > 8) {
			throw new ChessException("Error: not existing camps");
		}
		
		this.column = column;
		this.row = row;
	}

	public char getColumn() {
		return column;
	}

	public void setColumn(char column) {
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}
	
	
	/* A l�gica por tr�s do m�todo toPosition � bem simples:
	 * 
	 * A linha (row) vai de 1 a 8, mas em matrizes/arrays (classe Positon), vai de 0 a 7, o truque � simplesmente -
	 * pegar o �ltimo d�gito (8) e subtrair pelo input do usu�rio, desta forma, o retorno dessa subtra��o -
	 * �, e sempre ser�, uma posi��o do tabuleiro! Veja:
	 * 
	 * INPUT: '4D'
	 * 
	 * 8 - 4 = 4 <- linha do tabuleiro (matriz) equivale a 5, mas como imprimimos a partir do topo (0) -
	 * ser� a 4� posi��o no TABULEIRO!
	 * 
	 * O mesmo vale para o caracter, j� que o caracter UNICODE de 'a' � 0, o de 'b' � 1, de 'c' � 2, e assim por diante -
	 * se subtrairmos 'a' - 'a' = 0 <- obtemos um valor que podemos usar como posi��o, pois � int; 'b' - 'a' = 1; 'c' - 'a' = 2; ... 
	 * 
	 */
	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
	}
	
	// Agora a opera��o inversa: dada uma posi��o de matriz, converter para posi��o do tabuleiro
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char)('a' - position.getColumn()), 8 - position.getRow());
	}
	
	@Override
	public String toString() {
		return "" + column + row;
	}
}
