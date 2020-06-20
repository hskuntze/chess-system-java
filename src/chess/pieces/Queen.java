package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece {

	public Queen(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "Q";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position posAux = new Position(0, 0);

		posAux.setValues(position.getRow() - 1, position.getColumn());
		while (getBoard().positionExists(posAux) && !getBoard().thereIsAPiece(posAux)) {
			mat[posAux.getRow()][posAux.getColumn()] = true;
			posAux.setRow(posAux.getRow() - 1);
		}
		if (getBoard().positionExists(posAux) && isThereOpponentPiece(posAux)) {
			mat[posAux.getRow()][posAux.getColumn()] = true;
		}

		posAux.setValues(position.getRow(), position.getColumn() - 1);
		while (getBoard().positionExists(posAux) && !getBoard().thereIsAPiece(posAux)) {
			mat[posAux.getRow()][posAux.getColumn()] = true;
			posAux.setColumn(posAux.getColumn() - 1);
		}
		if (getBoard().positionExists(posAux) && isThereOpponentPiece(posAux)) {
			mat[posAux.getRow()][posAux.getColumn()] = true;
		}

		posAux.setValues(position.getRow() + 1, position.getColumn());
		while (getBoard().positionExists(posAux) && !getBoard().thereIsAPiece(posAux)) {
			mat[posAux.getRow()][posAux.getColumn()] = true;
			posAux.setRow(posAux.getRow() + 1);
		}
		if (getBoard().positionExists(posAux) && isThereOpponentPiece(posAux)) {
			mat[posAux.getRow()][posAux.getColumn()] = true;
		}

		posAux.setValues(position.getRow(), position.getColumn() + 1);
		while (getBoard().positionExists(posAux) && !getBoard().thereIsAPiece(posAux)) {
			mat[posAux.getRow()][posAux.getColumn()] = true;
			posAux.setColumn(posAux.getColumn() + 1);
		}
		if (getBoard().positionExists(posAux) && isThereOpponentPiece(posAux)) {
			mat[posAux.getRow()][posAux.getColumn()] = true;
		}

		posAux.setValues(position.getRow() - 1, position.getColumn() - 1);
		while (getBoard().positionExists(posAux) && !getBoard().thereIsAPiece(posAux)) {
			mat[posAux.getRow()][posAux.getColumn()] = true;
			posAux.setValues(posAux.getRow() - 1, posAux.getColumn() - 1);
		}
		if (getBoard().positionExists(posAux) && isThereOpponentPiece(posAux)) {
			mat[posAux.getRow()][posAux.getColumn()] = true;
		}

		posAux.setValues(position.getRow() - 1, position.getColumn() + 1);
		while (getBoard().positionExists(posAux) && !getBoard().thereIsAPiece(posAux)) {
			mat[posAux.getRow()][posAux.getColumn()] = true;
			posAux.setValues(posAux.getRow() - 1, posAux.getColumn() + 1);
		}
		if (getBoard().positionExists(posAux) && isThereOpponentPiece(posAux)) {
			mat[posAux.getRow()][posAux.getColumn()] = true;
		}

		posAux.setValues(position.getRow() + 1, position.getColumn() + 1);
		while (getBoard().positionExists(posAux) && !getBoard().thereIsAPiece(posAux)) {
			mat[posAux.getRow()][posAux.getColumn()] = true;
			posAux.setValues(posAux.getRow() + 1, posAux.getColumn() + 1);
		}
		if (getBoard().positionExists(posAux) && isThereOpponentPiece(posAux)) {
			mat[posAux.getRow()][posAux.getColumn()] = true;
		}

		posAux.setValues(position.getRow() + 1, position.getColumn() - 1);
		while (getBoard().positionExists(posAux) && !getBoard().thereIsAPiece(posAux)) {
			mat[posAux.getRow()][posAux.getColumn()] = true;
			posAux.setValues(posAux.getRow() + 1, posAux.getColumn() - 1);
		}
		if (getBoard().positionExists(posAux) && isThereOpponentPiece(posAux)) {
			mat[posAux.getRow()][posAux.getColumn()] = true;
		}

		return mat;
	}
}
