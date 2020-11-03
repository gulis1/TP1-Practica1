package logic.gameObjects;

import java.util.Random;

public class Player {
    int monedas;
    Random rng;

    public Player (Random rng) {
        this.monedas = 50;
        this.rng = rng;

    }

    public Boolean restarMonedas (int x) {
        boolean suficientes = false;

        if (x <= monedas) {
            suficientes = true;
            monedas -= x;
        }

        return suficientes;
    }

    public void addMonedas() {
        if (rng.nextFloat() < 0.5 ) {
            monedas += 10;
        }
    }

    public int getMonedas() {

        return monedas;
    }


}
