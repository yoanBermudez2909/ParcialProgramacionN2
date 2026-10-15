package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Funcion {

    private String codigo;
    private LocalDate fehca;
    private LocalTime horaInicio;
    private double precioBase;
    private Sala sala;
    private Pelicula pelicula;
    private List<Venta> listFuncionVentas;

    public Funcion(String codigo, LocalDate fehca, LocalTime horaInicio,
                   double precioBase, Sala sala, Pelicula pelicula) {

        this.codigo = codigo;
        this.fehca = fehca;
        this.horaInicio = horaInicio;
        this.precioBase = precioBase;
        this.sala = sala;
        this.pelicula = pelicula;
    }

    public boolean asientoDisponible(int fila, int numero) {

        for(Venta venta : listFuncionVentas){

            for(Boleta boleta : venta.getListVentaBoletas()){

                if(boleta.getFila() == fila && boleta.getNumeroAsiento() == numero){

                    return false;
                }
            }
        }

        return true;
    }

    public LocalTime calcularHoraFinal() {
        return horaInicio.plusMinutes(
                pelicula.getDuracionMinutos()
        );
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFehca() {
        return fehca;
    }

    public void setFehca(LocalDate fehca) {
        this.fehca = fehca;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    @Override
    public String toString() {
        return "Funcion{" +
                "codigo='" + codigo + '\'' +
                ", fehca=" + fehca +
                ", horaInicio=" + horaInicio +
                ", precioBase=" + precioBase +
                ", sala=" + sala +
                ", pelicula=" + pelicula +
                '}';
    }
}