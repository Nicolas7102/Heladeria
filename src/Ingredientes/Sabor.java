package Ingredientes;

public class Sabor {
    private String sabor;
    private boolean esLight;
    private int precio; //PRECIO POR KILO

    /**
     * @param precio Precio por kilo
     */
    public Sabor(String sabor, boolean esLight, int precio){
        this.sabor = sabor;
        this.esLight = esLight;
        this.precio = precio;
    }

    public void setPrecio(int precio){
        this.precio = precio;
    }

    public int getPrecio(){
        return this.precio;
    }

    public String getSabor(){
        return this.sabor;
    }

    public boolean esLight(){
        return this.esLight;
    }


}
