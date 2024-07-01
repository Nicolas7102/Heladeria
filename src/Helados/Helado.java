package Helados;

import Compras.Oferta;
import Ingredientes.Cobertura;
import Ingredientes.Porcion;
import Ingredientes.Sabor;

import java.util.ArrayList;

public abstract class Helado {
    protected ArrayList<Porcion> porciones;
    protected ArrayList<Cobertura> coberturas;
    protected int coberturasMax;
    protected int pesoMaximo;
    protected String tipoHelado;

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
