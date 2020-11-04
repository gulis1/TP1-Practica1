package logic.gameObjects;

import logic.Game;

public class Vampiro {
	private int x, y, vida, dmg, velocidad;
	private boolean muerto;
	private Game game;
	
	
	public Vampiro(int x, int y, Game game) {
		this.vida = 5;
		this.dmg = 1;
		this.x = x;
		this.y = y;
		//this.muerto= false;
		this.game = game;
	}

	public void move() {
		if (!game.getBoard().getSlayerList().existeSlayerEn(x - 1, y) && !game.getBoard().getVampireList().existeVampEn(x - 1,y))
			x--;
	}
	
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
