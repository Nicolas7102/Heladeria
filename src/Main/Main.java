package Main;

import Compras.Oferta;
import Compras.OfertasAlmacenadas;
import Helados.Cucurucho;
import Helados.Helado;
import Helados.UnKilo;
import Ingredientes.Cobertura;
import Compras.Compra;
import Ingredientes.Porcion;
import Ingredientes.Sabor;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

//TODO Hacer un segundo main donde haga un menu interactuable desde la consola. Este dejarlo como está.

public class Main {
    public static void main(String[] args) {
        //Sabores
        Sabor vainilla = new Sabor("Vainilla", false, 1000);
        Sabor chocolate = new Sabor("Chocolate", false, 2000);

        //Coberturas
        Cobertura salsaChocolate = new Cobertura("Salsa de Chocolate", false, 200);

        //Porciones
        Porcion chocolate100g = new Porcion(chocolate, 100);
        Porcion chocolate50g = new Porcion(chocolate, 50);

        Porcion vainilla50g = new Porcion(vainilla, 50);
        Porcion vainilla100g = new Porcion(vainilla, 100);
        Porcion vainilla500g = new Porcion(vainilla, 500);
        Porcion chocolate1k = new Porcion(chocolate, 1000);

        //Helados
        UnKilo kilo1 = new UnKilo();
        UnKilo kilo2 = new UnKilo();
        UnKilo kilo3 = new UnKilo();
        kilo1.agregarPorcion(chocolate1k);
        kilo2.agregarPorcion(chocolate1k);
        kilo3.agregarPorcion(chocolate1k);

        Cucurucho cucurucho1 = new Cucurucho();
        Cucurucho cucurucho2 = new Cucurucho();
        cucurucho1.agregarPorcion(chocolate50g);
        cucurucho1.agregarPorcion(chocolate50g);
        cucurucho1.agregarPorcion(vainilla50g);
        cucurucho2.agregarPorcion(chocolate100g);
        cucurucho2.agregarPorcion(chocolate50g);


        //Ofertas
        OfertasAlmacenadas ofertasAlmacenadas = OfertasAlmacenadas.getInstancia();
        Oferta oferta3kg20porciento = new Oferta(10, 2, 2500, new UnKilo().getTipoHelado());
        Oferta ofertaCucurucho2Unidades10porciento = new Oferta(5, 2, 2, new Cucurucho().getTipoHelado());

        ofertasAlmacenadas.almacenarOferta(oferta3kg20porciento);
        ofertasAlmacenadas.almacenarOferta(ofertaCucurucho2Unidades10porciento);

        //Compras
        Compra compra1 = new Compra();
        compra1.agregarHelado(kilo1);
        compra1.agregarHelado(kilo1);
        compra1.agregarHelado(kilo1);
        compra1.agregarHelado(cucurucho1);
        compra1.agregarHelado(cucurucho2);

        Compra compra2 = new Compra();
        compra2.agregarHelado(kilo1);

        System.out.printf("Compra 1: %.2f\n", compra1.calcularPrecio());

        //Consola
//        System.out.println(listarDatosHelado(kilo1));
//        System.out.println("> Peso: " + kilo1.calcularPeso() + "gms");
//        System.out.println("Total: $" + kilo1.calcularPrecio());
//
//        System.out.println();
//
//        System.out.println(listarDatosHelado(cucurucho1));
//        System.out.println("> Peso: " + cucurucho1.calcularPeso() + "gms");
//        System.out.println("Total: $" + cucurucho1.calcularPrecio());
    }

    public static String listarDatosHelado(Helado helado){
        String cadena = "";
        for (int i=0; i < helado.getSabores().size(); i++){
            cadena += i + 1 + " - " + helado.getSabores().get(i).getSabor() + " (" + helado.getPorciones().get(i).getPeso() + "gms - $" + (helado.getPorciones().get(i).getPeso() * (helado.getSabores().get(i).getPrecio() / 1000)) + ") | (XKilo - $" + helado.getSabores().get(i).getPrecio() + ")\n";
        }
        for (int i=0; i < helado.getCoberturas().size(); i++){
            cadena += "> " + helado.getCoberturas().get(i).getCobertura() + " ($" + helado.getCoberturas().get(i).getPrecio() + ")\n";
        }
        cadena += "> Es Light: " + helado.esLight();
        return cadena;
    }

    public static void GUI(){
        JFrame frame = new JFrame();
        frame.setTitle("Heladeria - Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(1100,600);
        frame.setVisible(true);

        ImageIcon icon = new ImageIcon("C:/Users/Nico/Desktop/Facultad 2024/Paradigma Orientado a Objetos/Heladeria/src/icon.png");
        frame.setIconImage(icon.getImage());
        frame.getContentPane().setBackground(new Color(66, 135, 245));
    }
}