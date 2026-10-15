package model;

import java.util.ArrayList;
import java.util.List;

public class Venta {
    private String codigo;
    private String fecha;

    private List<Boleta> listVentaBoletas;
    private Funcion funcion;
    private Cliente cliente;
    private Operario operario;

    public Venta(String codigo, String fecha, Funcion funcion, Cliente cliente, Operario operario) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.funcion = funcion;
        this.cliente = cliente;
        this.operario = operario;
        this.listVentaBoletas = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<Boleta> getListVentaBoletas() {
        return listVentaBoletas;
    }

    public void setListVentaBoletas(List<Boleta> listVentaBoletas) {
        this.listVentaBoletas = listVentaBoletas;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Operario getOperario() {
        return operario;
    }

    public void setOperario(Operario operario) {
        this.operario = operario;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "codigo='" + codigo + '\'' +
                ", fecha='" + fecha + '\'' +
                ", listVentaBoletas=" + listVentaBoletas +
                ", funcion=" + funcion +
                ", cliente=" + cliente +
                ", operario=" + operario +
                '}';
    }
}
