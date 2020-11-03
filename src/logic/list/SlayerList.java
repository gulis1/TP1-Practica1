package logic.list;

import logic.gameObjects.Slayer;
import logic.gameObjects.Vampiro;

public class SlayerList {

	private Slayer[] lista;
	private int numSlayer;

	public SlayerList() {
		numSlayer = 0;
		lista =  new Slayer[32];
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

	public boolean existeSlayerEn(int x, int y) {

		int i = 0;
		boolean existe = false;

		while (i < numSlayer && !existe) {

			if (lista[i].getX() == x && lista[i].getY() == y){
				existe = true;
			}

			i++;
		}

		return existe;
	}

	public void attack() {

		for (int i = 0; i < numSlayer; i++) {

			//lista[i].attack();
		}


	}

	public Slayer[] getList() {
		return lista;
	}

	public int getNumSlayer(){
		return numSlayer;
	}
}