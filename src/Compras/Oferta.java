package Compras;

import Helados.Helado;

public class Oferta {
    private int porcentajeDescuento;
    private int diaDescuento; // 0=Todos los dias, 1=Lunes, 7=Domingo
    private int cantidad;
    private String tipoHelado;

    //Tipos de oferta:
    // 1. Si la compra pesa mas de x kg
    // 2. Si la compra tiene mas de x tipo de helados.
    // 3. Ofertas en productos sellados. Cajas de bombones, etc. //TODO Agregar Bombones en Helados
    // 4. Demas tipos de ofertas no me quiero complicar. Si tuviera que haber haria una clase hija para cada tipo de oferta.

    /**
     * @param diaDescuento 0=Todos los dias, 1=Domingo, 7=Sabado
     * @param cantidad Si es de tipo Pote el valor se expresa en gramos. Si es de otro tipo se expresa la cantidad de unidades que se requiere para validar la oferta.
     * @param tipoHelado Tipo "Helado" sirve para todos los helados, sino especificar.
     */
    public Oferta(int porcentajeDescuento, int diaDescuento, int cantidad, String tipoHelado){
        this.porcentajeDescuento = porcentajeDescuento;
        this.diaDescuento = diaDescuento;
        this.cantidad = cantidad;
        this.tipoHelado = tipoHelado;
    }

     public String getTipoHelado() {
        return tipoHelado;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getDiaDescuento() {
        return diaDescuento;
    }

    public int getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void cambiarPorcentaje(int porcentajeDescuento){
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public void cambiarDiaDescuento(int diaDescuento){
        this.diaDescuento = diaDescuento;
    }

    public void cambiarCantidad(int cantidad){
        this.cantidad = cantidad;
    }

    public void cambiarTipoHelado(String tipoHelado){
        this.tipoHelado = tipoHelado;
    }
}
