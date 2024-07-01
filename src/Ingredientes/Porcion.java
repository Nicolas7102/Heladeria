package Ingredientes;

public class Porcion {
    private Sabor sabor;
    private int gms;

    public Porcion(Sabor sabor, int gms){
        this.sabor = sabor;
        this.gms = gms;
    }

    public int getPeso(){
        return this.gms;
    }

    public Sabor getSabor() {
        return this.sabor;
    }

    public void setGms(int gms){
        this.gms = gms;
    }
}
