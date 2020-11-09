package logic.gameObjects;

import logic.Game;

public class Vampiro {
	private int x, y, vida;
	private Game game;
	private boolean shouldMove;
	
	// constructor
	public Vampiro(int x, int y, Game game) {
		this.vida = 5;
		this.x = x;
		this.y = y;
		this.game = game;
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
    

}
