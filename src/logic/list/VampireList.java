package logic.list;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import logic.gameObjects.Vampiro;

public class VampireList {
    private Vampiro[] lista;
    private int numVamp;

    public  VampireList() {
        this.lista =  new Vampiro[10];
        this.numVamp = 0;
    }

    public void delVampire(int ind) {

        numVamp--;

        for (int i=ind; i < numVamp; i++) {

            lista[i] = lista[i+1];
        }
    }

    public void addVampire(Vampiro vamp) {

        lista[numVamp] = vamp;
        numVamp++;

    }

    public void attack() {

        for (int i = 0; i < numVamp; i++) {

            //lista[i].attack();
        }
    }

    public void move() {
        for (int i = 0; i < numVamp; i++) {

            lista[i].move();
        }
    }

    public boolean existeVampEn(int x, int y) {

        int i = 0;
        boolean existe = false;

        while (i < numVamp && !existe) {

            if (lista[i].getX() == x && lista[i].getY() == y){
                existe = true;
            }

            i++;
        }

        return existe;
    }

    public boolean alguienEnFinal() {
        int i = 0;
        boolean fin = false;

        while( i < numVamp && !fin) {
            if (lista[i].getX() == 0) {
                fin = true;
            }

            i++;
        }

        return fin;
    }

    public Vampiro[] getList() {
        return lista;
    }

    public int getNumVamp(){
        return numVamp;
    }
}
