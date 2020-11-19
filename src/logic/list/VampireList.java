package logic.list;


import logic.gameObjects.Vampiro;

public class VampireList {
    private Vampiro[] lista;


// constructor
    public  VampireList(int numVampLV) {
        this.lista =  new Vampiro[numVampLV];
    }
    
//Borra el vampiro en la posicion indice .
    public void delVampire(int ind) {

        Vampiro.restarVampiro();

        for (int i=ind; i < Vampiro.getNumVamp(); i++) {

            lista[i] = lista[i+1];
        }
    }

    // añade un vampiro a la lista.
    public void addVampire(Vampiro vamp) {

        lista[Vampiro.getNumVamp()] = vamp;
        Vampiro.addVampiro();


    }
    
//Recorre la lista para que los vampiros ataquen.
    public void attack() {

        for (int i = 0; i < Vampiro.getNumVamp(); i++) {

            lista[i].attack();
        }
    }

    //recorre la lista para hacer que los vampiros se muevan en su turno
    public void move() {
        for (int i = 0; i < Vampiro.getNumVamp(); i++) {

            lista[i].move();
        }
    }

    //comprueba si existe un vampiro en las coordenadas "x" e "y".
    public boolean existeVampEn(int x, int y) {

        int i = 0;
        boolean existe = false;

        while (i < Vampiro.getNumVamp() && !existe) {

            if (lista[i].getX() == x && lista[i].getY() == y && lista[i].getVida() > 0){
                existe = true;
            }

            i++;
        }

        return existe;
    }

    // Le resta vida al vampiro que se encuentra en la posicion del tablero (x,y) un de vida. Si no hay vampiro en esa posicion no se hace nada.
    public void restarVidaA(int x, int y) {
        int i = 0;
        boolean encontrado = false;

        while (i < Vampiro.getNumVamp() && !encontrado ) {

            if ( lista[i].getX() == x && lista[i].getY() == y) {
                lista[i].restarVida();
                encontrado = true;
            }

            i++;
        }

    }

    //comprueba si un vampiro esta muerto para eliminarlo de la lista.
    public void removeDeadVampires() {

        for (int i = 0; i < Vampiro.getNumVamp(); i++) {
            if (lista[i].getVida() <= 0)
                delVampire(i);
        }
    }
    
// funciones getters.
    public Vampiro[] getList() {
        return lista;
    }

}
