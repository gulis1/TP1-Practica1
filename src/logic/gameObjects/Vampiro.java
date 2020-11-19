package logic.gameObjects;

import logic.Game;

public class Vampiro {
	private int x, y, vida;
	private static Game game;
	private boolean shouldMove;

	private static int numVamp = 0;
	
	// constructor
	public Vampiro(int x, int y, Game game1) {
		this.vida = 5;
		this.x = x;
		this.y = y;
		game = game1;
		this.shouldMove = false;
	}

	// compruba si hay un vampiro o un slayer enfrente, si no lo hay si mueve; ademas de controlar la frecuencia de movimiento de cada Vampiro.
	public void move() {

		if (shouldMove) {
			if (!game.getBoard().getSlayerList().existeSlayerEn(x - 1, y) && !game.getBoard().getVampireList().existeVampEn(x - 1,y))
				x--;

			shouldMove = false;
		}

		else
			shouldMove = true;



	}
	//comprueba si hay un slayer enfrente  y si esta vivo ataca al slayer.
	public void attack() {

		if (game.getBoard().haySlayerEn(x-1, y) && vida > 0) {
			game.getBoard().getSlayerList().restarVidaA(x-1, y);

		}
	}


	// resta vida al vampiro.
	public void restarVida() {
		vida--;
	}
	
	// funciones getters 
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public int getVida() {
		return vida;
	}

	public static int getNumVamp() {
		return numVamp;
	}

	public static void addVampiro() {
		numVamp++;
	}

	public static boolean llegaronAlFinal() {
		int i = 0;
		boolean fin = false;

		while( i < Vampiro.getNumVamp() && !fin) {
			if (game.getBoard().getVampireList().getList()[i].getX() == 0) {
				fin = true;
			}

			i++;
		}

		return fin;
	}

	public static void restarVampiro() {
		numVamp--;
	}

	public static void resetVampiros() {
		numVamp = 0;
	}

}
