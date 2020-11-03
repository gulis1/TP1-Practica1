package logic;

import logic.gameObjects.Slayer;
import logic.gameObjects.Vampiro;
import logic.list.SlayerList;
import logic.list.VampireList;
import java.util.Random;

public class GameObjectBoard {
	Game game;
	private VampireList vampireList;
	private SlayerList slayerList;
	private int vampRestantes;
	private Random rng;

	public GameObjectBoard(Random rng, Game game) {
		vampRestantes = game.getLevel().numVampirosLv();
	    vampireList = new VampireList();
	    slayerList = new SlayerList();
	    this.rng= rng;
	    this.game = game;

    }

    public void summonVampires(Level level) {

		if (vampRestantes > 0 && rng.nextFloat() < level.getFrecuencia()) {
			int x = level.getDimX() - 1;
			int y = rng.nextInt(level.getDimY());

			if ( !vampireList.existeVampEn(x, y) ) {
				vampireList.addVampire(new Vampiro(x, y, game));
				vampRestantes--;
			}
		}

	}

	public VampireList getVampireList() {
		return vampireList;
	}

	public boolean hayVampEn(int x, int y) {
		return vampireList.existeVampEn(x,y);
	}

	public boolean haySlayerEn(int x, int y) {
		return slayerList.existeSlayerEn(x,y);
	}

	public SlayerList getSlayerList() {
		return slayerList;
	}

	public void addSlayer(int x, int y) {
		slayerList.addSlayer(new Slayer(x,y, game));
	}

	public int getVampTablero() {
		return vampireList.getNumVamp();
	}

	public boolean sePuedePonerSlayerEn(int x, int y) {

		return x >= 0 && x < game.getLevel().getDimX() - 1 && y >= 0 && y < game.getLevel().getDimY() && !hayVampEn(x,y) && !haySlayerEn(x,y);
	}

	public int getVampRestantes(){
		return vampRestantes;
	}
}
