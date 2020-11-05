package logic.gameObjects;

import logic.Game;

public class Slayer {
	
	
	private int x, y, vida;
	final int dmg;
	private boolean muerto;
	private Game game;
	
	
	public Slayer(int x, int y, Game game) {
		this.vida = 3;
		this.dmg = 1;
		this.x = x;
		this.y = y;
		this.muerto= false;
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

	public void restarVida() {
		vida--;
	}
	
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

	public int getVida() {
		return vida;
	}
	      

}
