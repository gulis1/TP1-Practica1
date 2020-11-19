package logic.list;

import logic.Game;
import logic.gameObjects.Slayer;
import logic.gameObjects.Vampiro;

public class SlayerList {

	private Slayer[] lista;

	// constructor
	public SlayerList(int dimx, int dimy) {
		lista =  new Slayer[dimx*dimy];
	}
// elimina un slayer segun el indice.
	public void delSlayer(int ind) {

		Slayer.restarSlayer();

		for (int i = ind; i < Slayer.getNumSlayer(); i++) {

			lista[i] = lista[i + 1];
		}
	}

	//añade un slayer a la lista.
	public void addSlayer(Slayer slayer) {

		lista[Slayer.getNumSlayer()] = slayer;
		Slayer.addSlayer();

	}

	//comprueba si hay  un slayer en la pocision "X" e "y".
	public boolean existeSlayerEn(int x, int y) {

		int i = 0;
		boolean existe = false;

		while (i < Slayer.getNumSlayer() && !existe) {

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

		while (i < Slayer.getNumSlayer() && !encontrado ) {

			if ( lista[i].getX() == x && lista[i].getY() == y) {
				lista[i].restarVida();
				encontrado = true;
			}

			i++;
		}

	}

	//recorre la lista para cada uno de los slayer ataquen.
	public void attack() {

		for (int i = 0; i < Slayer.getNumSlayer(); i++) {

			lista[i].attack();
		}
	}

	//recorre la lista y comprueba si hay slayers muertos, si lo hay lo elimina.
	public void removeDeadSlayers() {

		for (int i = 0; i < Slayer.getNumSlayer(); i++) {
			if (lista[i].getVida() == 0)
				delSlayer(i);
		}
	}
//funciones getters.
	public Slayer[] getList() {
		return lista;
	}

}