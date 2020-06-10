package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece{
	
	public Rook(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "R";
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		//posi��o auxiliar que representar� a posi��o no tabuleiro
		Position posAux = new Position(0,0);
		
		//para cima: decrementar as LINHAS, uma vez que, (linha 'n' - 1) representa o movimento para cima em uma MATRIZ
		posAux.setValues(position.getRow() - 1, position.getColumn()); //'position' � o atributo PROTECTED da classe 'PIECE', logo, estamos acessando a posi��o desta pe�a 'ROOK'
		while(getBoard().positionExists(posAux) && !getBoard().thereIsAPiece(posAux)) { //"ENQUANTO a posi��o 'posAux' existir e N�O estiver ocupada por uma pe�a" {...}
			mat[posAux.getRow()][posAux.getColumn()] = true; //pode mover
			posAux.setRow(posAux.getRow()-1); //move p/ cima
		}
		if(getBoard().positionExists(posAux) && isThereOpponentPiece(posAux)) { //"SE a posi��o existir no tabuleiro e estiver ocupada por um oponente {...}. OBS.: m�todo 'isThereOpponentPiece()' � protected de 'ChessPiece'"
			mat[posAux.getRow()][posAux.getColumn()] = true; //pode mover
		}
		
		//para a esquerda: decrementar as COLUNAS, uma vez que, (coluna 'n' - 1) representa o movimento para esquerda em uma MATRIZ
		posAux.setValues(position.getRow(), position.getColumn() - 1); //'position' � o atributo PROTECTED da classe 'PIECE', logo, estamos acessando a posi��o desta pe�a 'ROOK'
		while(getBoard().positionExists(posAux) && !getBoard().thereIsAPiece(posAux)) { //"ENQUANTO a posi��o 'posAux' existir e N�O estiver ocupada por uma pe�a" {...}
			mat[posAux.getRow()][posAux.getColumn()] = true; //pode mover
			posAux.setColumn(posAux.getColumn()-1); //move p/ esquerda
		}
		if(getBoard().positionExists(posAux) && isThereOpponentPiece(posAux)) { //"SE a posi��o existir no tabuleiro e estiver ocupada por um oponente {...}. OBS.: m�todo 'isThereOpponentPiece()' � protected de 'ChessPiece'"
			mat[posAux.getRow()][posAux.getColumn()] = true; //pode mover
		}
		
		//para a baixo: incrementar as LINHAS, uma vez que, (linha 'n' + 1) representa o movimento para baixo em uma MATRIZ
		posAux.setValues(position.getRow() + 1, position.getColumn()); //'position' � o atributo PROTECTED da classe 'PIECE', logo, estamos acessando a posi��o desta pe�a 'ROOK'
		while(getBoard().positionExists(posAux) && !getBoard().thereIsAPiece(posAux)) { //"ENQUANTO a posi��o 'posAux' existir e N�O estiver ocupada por uma pe�a" {...}
			mat[posAux.getRow()][posAux.getColumn()] = true; //pode mover
			posAux.setRow(posAux.getRow()+1); //move p/ baixo
		}
		if(getBoard().positionExists(posAux) && isThereOpponentPiece(posAux)) { //"SE a posi��o existir no tabuleiro e estiver ocupada por um oponente {...}. OBS.: m�todo 'isThereOpponentPiece()' � protected de 'ChessPiece'"
			mat[posAux.getRow()][posAux.getColumn()] = true; //pode mover
		}
		
		//para a direita: decrementar as COLUNAS, uma vez que, (coluna 'n' + 1) representa o movimento para direita em uma MATRIZ
		posAux.setValues(position.getRow(), position.getColumn() + 1); //'position' � o atributo PROTECTED da classe 'PIECE', logo, estamos acessando a posi��o desta pe�a 'ROOK'
		while(getBoard().positionExists(posAux) && !getBoard().thereIsAPiece(posAux)) { //"ENQUANTO a posi��o 'posAux' existir e N�O estiver ocupada por uma pe�a" {...}
			mat[posAux.getRow()][posAux.getColumn()] = true; //pode mover
			posAux.setColumn(posAux.getColumn()+1); //move p/ direita
		}
		if(getBoard().positionExists(posAux) && isThereOpponentPiece(posAux)) { //"SE a posi��o existir no tabuleiro e estiver ocupada por um oponente {...}. OBS.: m�todo 'isThereOpponentPiece()' � protected de 'ChessPiece'"
			mat[posAux.getRow()][posAux.getColumn()] = true; //pode mover
		}
		
		return mat;
	}
}
