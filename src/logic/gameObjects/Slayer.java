package logic.gameObjects;

import logic.Game;

public class Slayer {
	
	
	private int x, y, vida;
	private static int numSlayer = 0;
	final int dmg;
	private Game game;
	
	
	public Slayer(int x, int y, Game game) {
		this.vida = 3;
		this.dmg = 1;
		this.x = x;
		this.y = y;
		this.game = game;
	}
	
//busca al primer vampiro en la fila del slayer y le ataca.
	public void attack() {
		
		int i=x+1;
		boolean primerVamp=false;
		
	      while(i<game.getLevel().getDimX()-1 && !primerVamp) {
			
			if (game.getBoard().hayVampEn(i, y)) {
				primerVamp = true;
				game.getBoard().getVampireList().restarVidaA(i, y);
				
			}

			i++;
		}
		
	}
//resta la vida del slayer.
	public void restarVida() {
	vida--;
}

// funciones getters.
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getVida() {
		return vida;
	}

	public static int getNumSlayer() {
		return numSlayer;
	}

	public static void addSlayer() {
		numSlayer++;
	}

	public static void restarSlayer() {
		numSlayer--;
	}

	public static void resetSlayer() {
		numSlayer = 0;
	}
}
