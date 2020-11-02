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
	private int numVampAparecidos;
	private Random rng;

	public GameObjectBoard(Random rng, Game game) {
		numVampAparecidos = 0;
	    vampireList = new VampireList();
	    slayerList = new SlayerList();
	    this.rng= rng;
	    this.game = game;

    }

    public void summonVampires(Level level) {

		if (numVampAparecidos < level.numVampirosLv() && rng.nextFloat() < level.getFrecuencia()) {
			int x = level.getDimX() - 1;
			int y = rng.nextInt(level.getDimY());

			if ( !vampireList.existeVampEn(x, y) ) {
				vampireList.addVampire(new Vampiro(x, y, game));
				numVampAparecidos++;
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
}
