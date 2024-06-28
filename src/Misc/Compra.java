package Misc;

import Helados.Helado;

import java.util.ArrayList;

public class Compra {
    private ArrayList<Helado> helados;

    public Compra(){
        this.helados = new ArrayList<Helado>();
    }

    public void agregarHelado(Helado helado){
        this.helados.add(helado);
    }

    public void quitarHelado(Helado helado){ //TODO PROBAR SI ANDA
        this.helados.remove(helado);
    }
}
