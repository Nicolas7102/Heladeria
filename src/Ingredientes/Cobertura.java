package Ingredientes;

public class Cobertura {
    private String cobertura;
    private boolean esLight;
    private int precio;

    public Cobertura(String cobertura, boolean esLight, int precio){
        this.cobertura = cobertura;
        this.esLight = esLight;
        this.precio = precio;
    }

    public void setPrecio(int precio){
        this.precio = precio;
    }

    public int getPrecio(){
        return this.precio;
    }

    public String getCobertura(){
        return this.cobertura;
    }

    public boolean esLight(){
        return this.esLight;
    }
}
