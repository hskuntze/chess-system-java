package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece{
	
	private Color color;
	
	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
	//o m�todo se encontra na classe gen�rica 'ChessPiece' pois ser� reaproveitada em todas as pe�as
	protected boolean isThereOpponentPiece(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p != null && p.getColor() != color; //testando se a cor da pe�a resgatada na posi��o 'position'
												   //� a mesma cor 'source'.
	}
}
