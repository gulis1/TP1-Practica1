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
	    board = new GameObjectBoard(rng, this);
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

	public boolean isFinished() {
		return board.getVampireList().alguienEnFinal();
	}

	public void summonVampires() {

		board.summonVampires(level);
	}

	public void moveVampires() {
		board.getVampireList().move();
	}

	public boolean addSlayer(int x, int y) {
		boolean sePuede = false;

		if (sePuedePonerSlayerEn(x,y)) { //y monedas suficientes
			sePuede = true;

			board.addSlayer(x,y);

		}

		return sePuede;
	}

	private boolean sePuedePonerSlayerEn(int x, int y) {

		return x >= 0 && x < level.getDimX() - 1 && y >= 0 && y < level.getDimY() && !board.hayVampEn(x,y) && !board.haySlayerEn(x,y);
	}
}
