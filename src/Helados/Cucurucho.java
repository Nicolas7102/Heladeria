package Helados;

import Compras.Oferta;
import Ingredientes.Cobertura;
import Ingredientes.Porcion;
import Ingredientes.Sabor;

import java.util.ArrayList;
import java.util.HashSet;

public class Cucurucho extends Helado{
    public Cucurucho(){
        this.porciones = new ArrayList<Porcion>();
        this.coberturas = new ArrayList<Cobertura>();
        this.coberturasMax = 1;
        this.pesoMaximo = 150;
        this.tipoHelado = "Cucurucho";
    }

    @Override
    public void agregarPorcion(Porcion porcion) {
        if (porcion.getPeso() > pesoMaximo || porcion.getPeso() < 0) {
            System.out.println("Peso del sabor fuera de rango");
        } else if (this.calcularPeso() > pesoMaximo) {
            System.out.println("Ya se completó el cucurucho");
        } else if (this.contieneSabor(porcion)) {
            int i = indexBySabor(porcion);
            this.porciones.get(i).setGms(this.porciones.get(i).getPeso() + porcion.getPeso());
        } else {
            this.porciones.add(porcion);
        }
    }

    @Override
    public int indexBySabor(Porcion porcion) {
        int ind;
        int j = 0;
        while (true) {
            if (this.porciones.get(j).getSabor() == porcion.getSabor()) {
                ind = j;
                break;
            } else {
                j++;
            }
        }
        return ind;
    }

    @Override
    public void agregarCobertura(Cobertura cobertura) {
        if (coberturas.size() < coberturasMax){
            coberturas.add(cobertura);
        }
        else{
            System.out.println("No entran mas coberturas");
        }
    }

    @Override
    public ArrayList<Sabor> getSabores() {
        ArrayList<Sabor> aux = new ArrayList<>();
        for (int i=0; i<this.porciones.size(); i++){
            aux.add(this.porciones.get(i).getSabor());
        }
        return aux;
    }

    @Override
    public ArrayList<Cobertura> getCoberturas() {
        return this.coberturas;
    }

    @Override
    public int calcularPrecio() {
        int precio = 0;
        if (this.calcularPeso() < 100){
            System.out.print("Se debe llenar mas el cucurucho - ");
        }
        else{
            for (int i=0; i<this.porciones.size(); i++){
                precio += this.porciones.get(i).getPeso() * this.porciones.get(i).getSabor().getPrecio() / 1000;
            }
            for (int i = 0; i < this.coberturas.size(); i++){
                precio += coberturas.get(i).getPrecio();
            }
        }
        return precio;
    }

    @Override
    public boolean esLight() {
        boolean flag = true;
        for (int i = 0; i < this.porciones.size(); i++){
            if (!this.porciones.get(i).getSabor().esLight()){
                flag = false;
            }
        }
        for (int i = 0; i < this.coberturas.size(); i++){
            if (!this.coberturas.get(i).esLight()){
                flag = false;
            }
        }
        return flag;
    }

    @Override
    public int calcularPeso() {
        int peso = 0;
        for(int i=0; i<this.porciones.size(); i++){
            peso += this.porciones.get(i).getPeso();
        }
        return peso;
    }

    @Override
    public boolean contieneSabor(Porcion porcion) {
        boolean f = false;
        for(int i=0; i<this.porciones.size(); i++){
            if (this.porciones.get(i).getSabor() == porcion.getSabor()){
                f = true;
            }
        }
        return f;
    }

    @Override
    public ArrayList<Porcion> getPorciones() {
        return this.porciones;
    }

    @Override
    public String getTipoHelado(){
        return this.tipoHelado;
    }
}
