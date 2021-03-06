package view;

import com.sun.org.apache.bcel.internal.classfile.EnumElementValue;
import logic.Game;
import logic.gameObjects.Slayer;
import logic.gameObjects.Vampiro;
import utils.MyStringUtils;

public class GamePrinter {
	
	Game game;
	int numRows; 
	int numCols;
	String[][] board;
	final String space = " ";
	
	public GamePrinter (Game game, int cols, int rows) {
		this.game = game;
		this.numRows = rows;
		this.numCols = cols;
	}
	//saca por pantalla el tablero segun el nivel, ademas de recorrer las lista de slayers y vampiros para colocarlo en la poscion correspondiente.
	private void encodeGame(Game game) {
		
		board = new String[this.numRows][this.numCols];

		Vampiro[] listaV = game.getBoard().getVampireList().getList();
		int contV = Vampiro.getNumVamp();

		for (int i=0; i <numRows; i++){
			for (int j=0; j< numCols; j++){
				board[i][j] = " ";
			}
		}


		for (int i=0; i<contV; i++) {
			board[listaV[i].getY()][listaV[i].getX()] = String.format("V [%d]", listaV[i].getVida());
		}

		Slayer[] listaS = game.getBoard().getSlayerList().getList();
		int contS = Slayer.getNumSlayer();

		for (int i=0; i<contS; i++) {
			board[listaS[i].getY()][listaS[i].getX()] = String.format("S [%d]", listaS[i].getVida());
		}


	}
	
	 public String toString() {
		encodeGame(game);
		int cellSize = 7;
		int marginSize = 2;
		String vDelimiter = "|";
		String hDelimiter = "-";
		String intersect = space;
		String vIntersect = space;
		String hIntersect = "-";
		String corner = space;

		String cellDelimiter = MyStringUtils.repeat(hDelimiter, cellSize);

		String rowDelimiter = vIntersect + MyStringUtils.repeat(cellDelimiter + intersect, numCols-1) + cellDelimiter + vIntersect;
		String hEdge =  corner + MyStringUtils.repeat(cellDelimiter + hIntersect, numCols-1) + cellDelimiter + corner;

		String margin = MyStringUtils.repeat(space, marginSize);
		String lineEdge = String.format("%n%s%s%n", margin, hEdge);
		String lineDelimiter = String.format("%n%s%s%n", margin, rowDelimiter);

		StringBuilder str = new StringBuilder();

		str.append(lineEdge);
		for(int i=0; i<numRows; i++) {
		        str.append(margin).append(vDelimiter);
		        for (int j=0; j<numCols; j++)
		            str.append( MyStringUtils.centre(board[i][j], cellSize)).append(vDelimiter);
		        if (i != numRows - 1) str.append(lineDelimiter);
		        else str.append(lineEdge);   
		}

		return str.toString();
	    }
}

