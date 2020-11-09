package logic.list;


import logic.gameObjects.Vampiro;

public class VampireList {
    private Vampiro[] lista;
    private int numVamp;

// constructor
    public  VampireList() {
        this.lista =  new Vampiro[10];
        this.numVamp = 0;
    }
    
//Borra el vampiro en la posicion indice .
    public void delVampire(int ind) {

        numVamp--;

        for (int i=ind; i < numVamp; i++) {

            lista[i] = lista[i+1];
        }
    }

    // añade un vampiro a la lista.
    public void addVampire(Vampiro vamp) {

        lista[numVamp] = vamp;
        numVamp++;

    }
    
//Recorre la lista para que los vampiros ataquen.
    public void attack() {

        for (int i = 0; i < numVamp; i++) {

            lista[i].attack();
        }
    }

    //recorre la lista para hacer que los vampiros se muevan en su turno
    public void move() {
        for (int i = 0; i < numVamp; i++) {

            lista[i].move();
        }
    }

    //comprueba si existe un vampiro en las coordenadas "x" e "y".
    public boolean existeVampEn(int x, int y) {

        int i = 0;
        boolean existe = false;

        while (i < numVamp && !existe) {

            if (lista[i].getX() == x && lista[i].getY() == y && lista[i].getVida() > 0){
                existe = true;
            }

            i++;
        }

        return existe;
    }

    // comprueba si hay un vampiro en la ultima columna del tablero.
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

    // Le resta vida al vampiro que se encuentra en la posicion del tablero (x,y) un de vida. Si no hay vampiro en esa posicion no se hace nada.
    public void restarVidaA(int x, int y) {
        int i = 0;
        boolean encontrado = false;

        while (i < numVamp && !encontrado ) {

            if ( lista[i].getX() == x && lista[i].getY() == y) {
                lista[i].restarVida();
                encontrado = true;
            }

            i++;
        }

    }

    //comprueba si un vampiro esta muerto para eliminarlo de la lista.
    public void removeDeadVampires() {

        for (int i = 0; i < numVamp; i++) {
            if (lista[i].getVida() <= 0)
                delVampire(i);
        }
    }
    
// funciones getters.
    public Vampiro[] getList() {
        return lista;
    }

    public int getNumVamp(){
        return numVamp;
    }
}
