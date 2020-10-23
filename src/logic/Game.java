package logic;

import view.GamePrinter;

public class Game {
	
	private Level level;
	private long seed;
	private GamePrinter printer;
	
	public Game(Long seed, Level level) {
		this.level = level;
		this.seed = seed;
	    this.printer =  new GamePrinter(this, this.level.getDimX(), this.level.getDimY());
	}
	
	
	public String printGame() {
		
		return this.printer.toString();
	}
	
}
