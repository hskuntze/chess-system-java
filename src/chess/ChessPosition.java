package chess;

import boardgame.Position;


/* Considerações:
 * 
 * Uma posição no XADREZ é diferente da forma como tratamos arrays em programação -
 * mesmo sabendo que um tabuleiro é uma matriz, temos de respeitar as regras de ne-
 * gócios e implementar a solução devida. Uma posição no xadrez é dada como uma le-
 * tra e um número, sendo a letra o eixo das abcissas (X) e o número o eixo das or-
 * denadas (Y), ou, se preferir, letra equivale a 'i' e número a 'j'.
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
	
	
	/* A lógica por trás do método toPosition é bem simples:
	 * 
	 * A linha (row) vai de 1 a 8, mas em matrizes/arrays (classe Positon), vai de 0 a 7, o truque é simplesmente -
	 * pegar o último dígito (8) e subtrair pelo input do usuário, desta forma, o retorno dessa subtração -
	 * é, e sempre será, uma posição do tabuleiro! Veja:
	 * 
	 * INPUT: '4D'
	 * 
	 * 8 - 4 = 4 <- linha do tabuleiro (matriz) equivale a 5, mas como imprimimos a partir do topo (0) -
	 * será a 4ª posição no TABULEIRO!
	 * 
	 * O mesmo vale para o caracter, já que o caracter UNICODE de 'a' é 0, o de 'b' é 1, de 'c' é 2, e assim por diante -
	 * se subtrairmos 'a' - 'a' = 0 <- obtemos um valor que podemos usar como posição, pois é int; 'b' - 'a' = 1; 'c' - 'a' = 2; ... 
	 * 
	 */
	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
	}
	
	// Agora a operação inversa: dada uma posição de matriz, converter para posição do tabuleiro
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char)('a' - position.getColumn()), 8 - position.getRow());
	}
	
	@Override
	public String toString() {
		return "" + column + row;
	}
}
