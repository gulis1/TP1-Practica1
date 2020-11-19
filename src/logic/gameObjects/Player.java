package logic.gameObjects;

import java.util.Random;

public class Player {
    private int monedas;
    private Random rng;
//constructor
    public Player (Random rng) {
        this.monedas = 50;
        this.rng = rng;

    }
// comprueba si tiene monedas suficientes para comprar un slayer.(si tiene lo compra y le resta la cantidad)
    public Boolean restarMonedas (int x) {
        boolean suficientes = false;

        if (x <= monedas) {
            suficientes = true;
            monedas -= x;
        }

        return suficientes;
    }
  // a�aden monedas segun el rng.
    public void addMonedas() {
        if (rng.nextFloat() > 0.5 ) {
            monedas += 10;
        }
    }
// funcion getters.
    public int getMonedas() {

        return monedas;
    }


}
