package logic;

import view.GamePrinter;

import java.util.Random;

public class Game {
	
	private Level level;
	private long seed;
	private GamePrinter printer;
	private GameObjectBoard board;
	private Random rng;
	
	public Game(Long seed, Level level) {
		this.level = level;
		this.seed = seed;
		rng = new Random(seed);
	    printer =  new GamePrinter(this, this.level.getDimX(), this.level.getDimY());
	    board = new GameObjectBoard(rng);
	}
	
	
	public String printGame() {
		
		return this.printer.toString();
	}

	public long getSeed() {
		return seed;
	}

	public GameObjectBoard getBoard() {
		return board;
	}

	public Level getLevel() {
		return level;
	}
}
