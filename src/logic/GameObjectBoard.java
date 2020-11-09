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
	
// constructor
	public GameObjectBoard(Random rng, Game game) {
		vampRestantes = game.getLevel().numVampirosLv();
	    vampireList = new VampireList();
	    slayerList = new SlayerList();
	    this.rng= rng;
	    this.game = game;

    }

	//comprueba si exite un vampiro en la posicion en la que se quiere colocar (escogida a traves del rng)
    public void summonVampires(Level level) {

		if (vampRestantes > 0 && rng.nextDouble() < level.getFrecuencia()) {
			int x = level.getDimX() - 1;
			int y = rng.nextInt(level.getDimY());

			if ( !vampireList.existeVampEn(x, y) ) {
				vampireList.addVampire(new Vampiro(x, y, game));
				vampRestantes--;
			}
		}

	}
//comprueba si hay un vampiro en "X" e "Y"
	public boolean hayVampEn(int x, int y) {
		return vampireList.existeVampEn(x,y);
	}

	//comprueba si hay un slayer en "X" e "Y"
	public boolean haySlayerEn(int x, int y) {
		return slayerList.existeSlayerEn(x,y);
	}

	//añade un slayer
	public void addSlayer(int x, int y) {
		slayerList.addSlayer(new Slayer(x,y, game));
	}

	//comprueba si puede poner un slayer en la posicion "X" e "Y".
	public boolean sePuedePonerSlayerEn(int x, int y) {

		return x >= 0 && x < game.getLevel().getDimX() - 1 && y >= 0 && y < game.getLevel().getDimY() && !hayVampEn(x,y) && !haySlayerEn(x,y);
	}

	//remueve los elementos muertos del tablero.
	public void removeDead() {

		vampireList.removeDeadVampires();
		slayerList.removeDeadSlayers();


	}
//atacan los objetos del tablero.
	public void attack() {
		slayerList.attack();
		vampireList.attack();
		removeDead();
	}
// funciones getters.
	public int getVampRestantes(){
		return vampRestantes;
	}

	public int getVampTablero() {
		return vampireList.getNumVamp();
	}

	public VampireList getVampireList() {
		return vampireList;
	}

	public SlayerList getSlayerList() {
		return slayerList;
	}
}
