package logic.gameObjects;

import logic.Game;

public class Vampiro {
	private int x, y, vida, dmg, velocidad;
	private Game game;
	
	
	public Vampiro(int x, int y) {
		this.vida = 5;
		this.dmg = 1;
		this.x = x;
		this.y = y;	
	}

	public void move() {
		x--;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
