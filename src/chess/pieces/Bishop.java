package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece{
	
	public Bishop(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "B";
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		//posi��o auxiliar que representar� a posi��o no tabuleiro
		Position posAux = new Position(0,0);
		
		//noroeste
		posAux.setValues(position.getRow() - 1, position.getColumn() - 1); 
		while(getBoard().positionExists(posAux) && !getBoard().thereIsAPiece(posAux)) { 
			mat[posAux.getRow()][posAux.getColumn()] = true; 
			posAux.setValues(posAux.getRow()-1, posAux.getColumn()-1);
		}
		if(getBoard().positionExists(posAux) && isThereOpponentPiece(posAux)) { 
			mat[posAux.getRow()][posAux.getColumn()] = true; 
		}
		
		//nordeste
		posAux.setValues(position.getRow() - 1, position.getColumn() + 1); 
		while(getBoard().positionExists(posAux) && !getBoard().thereIsAPiece(posAux)) { 
			mat[posAux.getRow()][posAux.getColumn()] = true; 
			posAux.setValues(posAux.getRow() - 1, posAux.getColumn() + 1); 
		}
		if(getBoard().positionExists(posAux) && isThereOpponentPiece(posAux)) { 
			mat[posAux.getRow()][posAux.getColumn()] = true; 
		}
		
		//sudeste
		posAux.setValues(position.getRow() + 1, position.getColumn() + 1); 
		while(getBoard().positionExists(posAux) && !getBoard().thereIsAPiece(posAux)) { 
			mat[posAux.getRow()][posAux.getColumn()] = true; 
			posAux.setValues(posAux.getRow() +1, posAux.getColumn() + 1); 
		}
		if(getBoard().positionExists(posAux) && isThereOpponentPiece(posAux)) { 
			mat[posAux.getRow()][posAux.getColumn()] = true; 
		}
		
		//sudoeste
		posAux.setValues(position.getRow() + 1, position.getColumn() - 1); 
		while(getBoard().positionExists(posAux) && !getBoard().thereIsAPiece(posAux)) { 
			mat[posAux.getRow()][posAux.getColumn()] = true; 
			posAux.setValues(posAux.getRow() + 1, posAux.getColumn() - 1);
		}
		if(getBoard().positionExists(posAux) && isThereOpponentPiece(posAux)) { 
			mat[posAux.getRow()][posAux.getColumn()] = true; 
		}
		
		return mat;
	}
}
