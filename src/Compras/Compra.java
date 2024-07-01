package Compras;

import Helados.Helado;
import java.util.ArrayList;
import java.util.Calendar;

public class Compra {
    private ArrayList<Helado> helados;

    public Compra(){
        this.helados = new ArrayList<Helado>();
        //this.ofertas = new HashSet<>();
    }

    public void agregarHelado(Helado helado){
        this.helados.add(helado);
    }

    public void quitarHelado(Helado helado){
        this.helados.remove(helado);
    }

    public int calcularPesoTotal(){
        int peso = 0;
        for (int i=0; i<this.helados.size(); i++){
            peso += this.helados.get(i).calcularPeso();
        }
        return peso;
    }

    private ArrayList<Oferta> ofertasAlmacenadasInstancia(){
        OfertasAlmacenadas ofertasSingleton = OfertasAlmacenadas.getInstancia();
        return ofertasSingleton.getOfertas();
    }

    public float calcularPrecio(){
        float desc = 0;

        float precioAux = 0;
        for (int i=0; i<this.helados.size(); i++){
            precioAux += this.helados.get(i).calcularPrecio();
        }

        System.out.print("Precio base: $" + precioAux);

        for (int i = 0; i < ofertasAlmacenadasInstancia().size(); i++) {
                desc = validarOferta();
            }

        precioAux = precioAux - (precioAux * (desc / 100f));

        System.out.println(" - Descuento: " + desc + "%");
        return precioAux;
    }

    /**
     * Si una oferta es de tipo "2KG 10% de descuento" este metodo verifica que los dos kilos sean acumulados en helados de tipo "Pote". Y si es por la cantidad de un tipo de helado lo verifica.
     * @return Devuelve el porcentaje de descuento
     */
    // Si la oferta es de tipo Pote = Descuento al alcanzar x cantidad de gramos en los potes
    // Si es de tipo Cucurucho = Descuento al alcanzar x cantidad de cucuruchos
    private float validarOferta(){
        Calendar cal = Calendar.getInstance();
        int hoy = cal.get(Calendar.DAY_OF_WEEK);

        float descuento = 0;

        ArrayList<Oferta> ofertasInstancia = ofertasAlmacenadasInstancia();

        if (!ofertasInstancia.isEmpty()){
            int pesoPotes = 0;
            int qtyCucurucho = 0;
            // Agregar los que hagan falta en el futuro

            // Contar los tipos de helados que hay en la compra
            for (int i= 0; i<this.helados.size(); i++){
                if (this.helados.get(i).getTipoHelado().equals("Pote")){
                    pesoPotes += this.helados.get(i).calcularPeso();
                } else if (this.helados.get(i).getTipoHelado().equals("Cucurucho")){
                    qtyCucurucho += 1;
                }
            }

            for (int i = 0; i < ofertasInstancia.size(); i++) {
                if (ofertasAlmacenadasInstancia().get(i).getDiaDescuento() == 0 || ofertasAlmacenadasInstancia().get(i).getDiaDescuento() == hoy) {
                    if (ofertasInstancia.get(i).getTipoHelado().equals("Pote")) {
                        if (pesoPotes >= ofertasInstancia.get(i).getCantidad()) {
                            descuento += ofertasInstancia.get(i).getPorcentajeDescuento();
                        }
                    } else if (ofertasInstancia.get(i).getTipoHelado().equals("Cucurucho")) {
                        if (qtyCucurucho >= ofertasInstancia.get(i).getCantidad()) {
                            descuento += ofertasInstancia.get(i).getPorcentajeDescuento();
                        }
                    }
                }
            }
        }
        return descuento;
    }
}
