package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Cine {
    private String nombreComercial;
    private String nit;
    private String direccion;

    private List<Sala>listCineSalas;
    private List<Pelicula>listCinePeliculas;
    private List<Funcion>listCineFunciones;
    private List<Persona>listCinePersonas;
    private List<Venta>listCineVentas;

    public Cine(String nombreComercial, String nit, String direccion, List<Sala> listCineSalas, List<Pelicula> listCinePeliculas, List<Funcion> listCineFunciones, List<Persona> listCinePersonas, List<Venta> listCineVentas) {
        this.nombreComercial = nombreComercial;
        this.nit = nit;
        this.direccion = direccion;
        this.listCineSalas = listCineSalas;
        this.listCinePeliculas = listCinePeliculas;
        this.listCineFunciones = listCineFunciones;
        this.listCinePersonas = listCinePersonas;
        this.listCineVentas = listCineVentas;
    }

    public void registrarCliente(String documento, String nombre, String correo, String telefono, String codigoAfilacion, double porcentajeDescuento){
        if(buscarPersona(documento) == null){
        Cliente cliente = new Cliente(documento, nombre, correo, telefono, codigoAfilacion, porcentajeDescuento);
        listCinePersonas.add(cliente);
        }
    }

    public void registrarOperario(String documento, String nombre, String correo, String telefono, String codigoEmpleado, String fechaContratacion, double salarioBasico){
        if(buscarPersona(documento) == null){
            Operario operario = new Operario(documento, nombre, correo, telefono, codigoEmpleado, fechaContratacion, salarioBasico);
            listCinePersonas.add(operario);
        }
    }

    public Persona buscarPersona(String documento){
        for(Persona p:listCinePersonas){
            if(p.getDocumento().equals(documento)){
                return p;
            }
        }
        return null;
    }

    public Pelicula buscarPelicula(String codigo){
        for(Pelicula peli : listCinePeliculas){
        if(peli.getCodigo().equals(codigo)){
            return peli;
            }
        }
        return null;
    }

    public void agregarPelicula(String codigo, String titulo, int duracionMinutos, String clasifiEdad, GeneroPelicula generoPelicula){
        if(buscarPelicula(codigo) == null){
            Pelicula peli = new Pelicula(codigo, titulo, duracionMinutos, clasifiEdad, generoPelicula);
            listCinePeliculas.add(peli);
        }
    }

    public void programarFuncion (String codigo, LocalDate fehca, LocalTime horaInicio, double precioBase, Pelicula pelicula, Sala sala){
        if(!detectarConflicto(sala, fehca, horaInicio, pelicula)){
            Funcion funcion = new Funcion(codigo, fehca, horaInicio, precioBase, sala, pelicula);
            listCineFunciones.add(funcion);
        }
    }

    public boolean detectarConflicto(Sala sala, LocalDate fehca, LocalTime horaInicio, Pelicula pelicula){
        LocalTime horaFinNueva = horaInicio.plusMinutes(pelicula.getDuracionMinutos());
        for(Funcion funcion : listCineFunciones){
            if(funcion.getSala().equals(sala) && funcion.getFehca().equals(fehca)){
                LocalTime inicioExistente = funcion.getHoraInicio();
                LocalTime finExistente = funcion.calcularHoraFinal();
                if(horaInicio.isBefore(finExistente)
                        && horaFinNueva.isAfter(inicioExistente)){
                    return true;
                }
            }
        }

        return false;
    }


    public void realizarVenta ()




    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Sala> getListCineSalas() {
        return listCineSalas;
    }

    public void setListCineSalas(List<Sala> listCineSalas) {
        this.listCineSalas = listCineSalas;
    }

    public List<Pelicula> getListCinePeliculas() {
        return listCinePeliculas;
    }

    public void setListCinePeliculas(List<Pelicula> listCinePeliculas) {
        this.listCinePeliculas = listCinePeliculas;
    }

    public List<Funcion> getListCineFunciones() {
        return listCineFunciones;
    }

    public void setListCineFunciones(List<Funcion> listCineFunciones) {
        this.listCineFunciones = listCineFunciones;
    }

    public List<Persona> getListCinePersonas() {
        return listCinePersonas;
    }

    public void setListCinePersonas(List<Persona> listCinePersonas) {
        this.listCinePersonas = listCinePersonas;
    }

    public List<Venta> getListCineVentas() {
        return listCineVentas;
    }

    public void setListCineVentas(List<Venta> listCineVentas) {
        this.listCineVentas = listCineVentas;
    }

    @Override
    public String toString() {
        return "Cine{" +
                "nombreComercial='" + nombreComercial + '\'' +
                ", nit='" + nit + '\'' +
                ", direccion='" + direccion + '\'' +
                ", listCineSalas=" + listCineSalas +
                ", listCinePeliculas=" + listCinePeliculas +
                ", listCineFunciones=" + listCineFunciones +
                ", listCinePersonas=" + listCinePersonas +
                ", listCineVentas=" + listCineVentas +
                '}';
    }
}
