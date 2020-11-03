package logic.gameObjects;

import logic.Game;

public class Slayer {
	
	
	private int x, y, vida;
	final int dmg;
	private Game game;
	
	
	public Slayer(int x, int y, Game game) {
		this.vida = 3;
		this.dmg = 1;
		this.x = x;
		this.y = y;
		this.game = game;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
