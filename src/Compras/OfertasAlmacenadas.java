package Compras;

import java.util.ArrayList;
import java.util.HashSet;

public class OfertasAlmacenadas {
    private static OfertasAlmacenadas instancia;
    private HashSet<Oferta> ofertas;

    public OfertasAlmacenadas(){
        this.ofertas = new HashSet<>();
    }

    public static OfertasAlmacenadas getInstancia(){
        if (instancia == null){
            instancia = new OfertasAlmacenadas();
        }
        return instancia;
    }

    /**
     * @return Nunca va a tener el mismo orden al venir de un HashSet
     */
    public ArrayList<Oferta> getOfertas(){
        return new ArrayList<>(this.ofertas);
    }

    public void almacenarOferta(Oferta oferta){
        this.ofertas.add(oferta);
    }

    public void eliminarOferta(Oferta oferta) {
        this.ofertas.remove(oferta);
    }
}
