package logic.list;

import logic.gameObjects.Slayer;

public class SlayerList {

	private Slayer[] lista;
	private int numSlayer;

	public void SlayerLista() {
		numSlayer = 0;
		lista  = new Slayer[32];
	}

	public void delSlayer(int ind) {

		numSlayer--;

		for (int i = ind; i < numSlayer; i++) {

			lista[i] = lista[i + 1];
		}
	}

	public void addSlayer(Slayer slayer) {

		lista[numSlayer] = slayer;
		numSlayer++;

	}

	public void atack() {

		for (int i = 0; i < numSlayer; i++) {

			//lista[i].attack();
		}


	}
}