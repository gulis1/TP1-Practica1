package logic.gameObjects;

import logic.Game;

public class Vampiro {
	private int x, y, vida;
	private Game game;
	private boolean shouldMove;
	
	
	public Vampiro(int x, int y, Game game) {
		this.vida = 5;
		this.x = x;
		this.y = y;
		this.game = game;
		this.shouldMove = false;
	}

	public void move() {

		if (shouldMove) {
			if (!game.getBoard().getSlayerList().existeSlayerEn(x - 1, y) && !game.getBoard().getVampireList().existeVampEn(x - 1,y))
				x--;

			shouldMove = false;
		}

		else
			shouldMove = true;



	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void restarVida() {
		vida--;
	}

	public void attack() {

		if (game.getBoard().haySlayerEn(x-1, y) && vida > 0) {
			game.getBoard().getSlayerList().restarVidaA(x-1, y);

		}
	}
	
	public int getVida() {
		return vida;
	}
    

}
