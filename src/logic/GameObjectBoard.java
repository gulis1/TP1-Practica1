package logic;

import logic.gameObjects.Vampiro;
import logic.list.SlayerList;
import logic.list.VampireList;
import java.util.Random;

public class GameObjectBoard {
	private VampireList vampireList;
	private SlayerList slayerList;
	private int numVampAparecidos;
	private Random rng;

	public GameObjectBoard(Random rng) {
		numVampAparecidos = 0;
	    vampireList = new VampireList();
	    slayerList = new SlayerList();
	    this.rng= rng;

    }

    public void summonVampires(Level level) {

		if (numVampAparecidos < level.numVampirosLv() && rng.nextFloat() < level.getFrecuencia()) {
			int x = level.getDimX() - 1;
			int y = rng.nextInt(level.getDimY());

			if ( !vampireList.existeVampEn(x, y) ) {
				vampireList.addVampire(new Vampiro(x, y));
				numVampAparecidos++;
			}
		}

	}

	public VampireList getVampireList() {
		return vampireList;
	}
}
