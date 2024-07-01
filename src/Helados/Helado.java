package Helados;

import Compras.Oferta;
import Ingredientes.Cobertura;
import Ingredientes.Porcion;
import Ingredientes.Sabor;

import java.util.ArrayList;
import java.util.HashSet;

public abstract class Helado {
    protected ArrayList<Porcion> porciones;
    protected ArrayList<Cobertura> coberturas;
    protected int coberturasMax;
    protected int pesoMaximo;
    protected String tipoHelado; // Este atributo es para clasificar los helados para las ofertas. Hay ofertas exclusivas para cucuruchos, para potes, etc.

    // Agregar metodo quitarSabor?
    // Agregar excepciones
    // Agregar algunos helados mas
    // En el menu agregar una opcion de mostrar datos de la compra, con los datos del helado
    // Es considerado singleton??. Cuando funcione revisar como es una clase singleton de verdad.

    // Al finalizar hacer el diagrama de clases
    // Al hacer el informe. Al principio explicar si tengo relacion con el negocio, por que lo elegi, si encontre la necesidad de algo o no, si resuelve algo, intentar venderlo. Explicar la funcionalidad de algunas clases clave, por que elegi hacerlo de esa manera. Describir como se maneja la heladeria, si tiene algun combo, que consideraciones tiene para crear los helados. Conclusion al final de que me parecio el codigo. Debe ser un pdf con un link al codigo en GIT
    // En el informe podria llegar a hacer un "mapa" de funcionalidades del GUI, con indices numericos en cada punto interactuable y no interactuable de la interfaz, explicando puntos importantes e interesantes.

    // Notas finales
    // Interfaz no sirve para este caso
    // Si hago GUI lo hago como una clase
    // Las ofertas hay que almacenarlas manualmente en el main

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
    public abstract String getTipoHelado();

    public abstract int calcularPeso();
    public abstract int calcularPrecio();
    public abstract boolean esLight();
}
