package logic;

import logic.gameObjects.Player;
import view.GamePrinter;

import java.util.Random;

public class Game {
	
	private Level level;
	private long seed;
	private GamePrinter printer;
	private GameObjectBoard board;
	private Random rng;
	private int ciclo;
	private Player player;
	
	public Game(Long seed, Level level) {
		this.ciclo = 0;
		this.level = level;
		this.seed = seed;
		rng = new Random(seed);
	    printer =  new GamePrinter(this, this.level.getDimX(), this.level.getDimY());
	    board = new GameObjectBoard(rng, this);
	    player = new Player(rng);

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

		if (board.sePuedePonerSlayerEn(x,y) && player.restarMonedas(50)) {
			sePuede = true;

			board.addSlayer(x,y);

		}

		return sePuede;
	}



	private void incrementarCiclo() {
		ciclo++;
	}

	public int getCiclo() {
		return ciclo;
	}

	public void incrementarMonedas () {
		player.addMonedas();
	}

	public Player getPlayer() {
		return player;
	}

 }
