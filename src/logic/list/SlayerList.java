package logic.list;

import logic.gameObjects.Slayer;
import logic.gameObjects.Vampiro;

public class SlayerList {

	private Slayer[] lista;
	private int numSlayer;
	
	// constructor
	public SlayerList() {
		numSlayer = 0;
		lista =  new Slayer[32];
	}
// elimina un slayer segun el indice.
	public void delSlayer(int ind) {

		numSlayer--;

		for (int i = ind; i < numSlayer; i++) {

			lista[i] = lista[i + 1];
		}
	}

	//añade un slayer a la lista.
	public void addSlayer(Slayer slayer) {

		lista[numSlayer] = slayer;
		numSlayer++;

	}

	//comprueba si hay  un slayer en la pocision "X" e "y".
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

	// Le resta al slayer que se encuentra en la posicion del tablero (x,y) un de vida. Si no hay vampiro en esa posicion no se hace nada.
	public void restarVidaA(int x, int y) {
		int i = 0;
		boolean encontrado = false;

		while (i < numSlayer && !encontrado ) {

			if ( lista[i].getX() == x && lista[i].getY() == y) {
				lista[i].restarVida();
				encontrado = true;
			}

			i++;
		}

	}

	//recorre la lista para cada uno de los slayer ataquen.
	public void attack() {

		for (int i = 0; i < numSlayer; i++) {

			lista[i].attack();
		}
	}

	//recorre la lista y comprueba si hay slayers muertos, si lo hay lo elimina.
	public void removeDeadSlayers() {

		for (int i = 0; i < numSlayer; i++) {
			if (lista[i].getVida() == 0)
				delSlayer(i);
		}
	}
//funciones getters.
	public Slayer[] getList() {
		return lista;
	}

	public int getNumSlayer(){
		return numSlayer;
	}


}