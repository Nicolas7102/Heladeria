package Helados;

import Misc.Cobertura;
import Misc.Porcion;
import Misc.Sabor;

import java.util.ArrayList;

public abstract class Helado {
    protected ArrayList<Porcion> porciones;
    protected ArrayList<Cobertura> coberturas;
    protected int coberturasMax;
    protected int pesoMaximo;

    // Agregar metodo quitarSabor?
    // Agregar excepciones
    // Agregar ofertas / combos
    // Agregar algunos helados mas
    // Donde usar una interfaz?
    //TODO Como hago si una persona compra mas de un helado? --> Crear clase Orden/Compra/Factura con un arraylist de tipo helado, descuento en efectivo? Descuento si tiene dos kilos o algo por el estilo. Agregar getDate() al "ticket"

    // Hacer el gui como una clase
    // Crear cupones de descuento
    // Deberia poner el metodo del main en las clases
    // Al finalizar hacer el diagrama de clases
    // Al hacer el informe. Al principio explicar si tengo relacion con el negocio, por que lo elegi, si encontre la necesidad de algo o no, si resuelve algo, intentar venderlo. Explicar la funcionalidad de algunas clases clave, por que elegi hacerlo de esa manera. Describir como se maneja la heladeria, si tiene algun combo, que consideraciones tiene para crear los helados. Conclusion al final de que me parecio el codigo. Debe ser un pdf con un link al codigo en GIT
    // En el informe podria llegar a hacer un "mapa" de funcionalidades del GUI, con indices numericos en cada punto interactuable y no interactuable de la interfaz, explicando puntos importantes e interesantes.

    /**
     * Si el sabor ya existe lo acumulo como una sola porcion
     */
    public abstract void agregarPorcion(Porcion porcion);
    public abstract void agregarCobertura(Cobertura cobertura);
    public abstract boolean contieneSabor(Porcion porcion);
    public abstract int indexBySabor(Porcion porcion);

    public abstract ArrayList<Porcion> getPorciones();
    public abstract ArrayList<Sabor> getSabores();
    public abstract ArrayList<Cobertura> getCoberturas();

    public abstract int calcularPeso();
    public abstract int calcularPrecio();
    public abstract boolean esLight();
}
