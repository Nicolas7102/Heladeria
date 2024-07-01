package Main;

import Compras.Compra;

import java.util.ArrayList;
import java.util.Scanner;

public class MainInteractuable {
    public static void main(String[] args) {
        try {
            menu1();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void menu1() {
        System.out.println("1- Crear nueva compra");
        System.out.println("2- Listar compras realizadas");
        int opcion = 0;

        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Elegir una opcion: ");
                opcion = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Error menu 1: " + e);
            }
            if (opcion > 0 && opcion <3){
                break;
            }
        }
        if (opcion == 1){
            Scanner sc = new Scanner(System.in);
            System.out.print("");
        }
    }

    private static void menu2(int opc){
        System.out.println("1- Agregar Helado");
        System.out.println("2- Agregar Cobertura");
    }

    private static ArrayList<Compra> compras = new ArrayList<>();
}
