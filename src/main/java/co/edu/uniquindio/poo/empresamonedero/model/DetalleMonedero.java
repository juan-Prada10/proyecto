package co.edu.uniquindio.poo.empresamonedero.model;

import java.util.ArrayList;

public class DetalleMonedero {

    private String nombre;
    private String codigo;
    private double saldo;

    private Monedero ownedByMonedero;
    private ArrayList<Transaccion> listaTransacciones = new ArrayList<>();

    public DetalleMonedero(String nombre, String codigo, double saldo, Monedero ownedByMonedero) {
        this.nombre = nombre;
        this.ownedByMonedero = ownedByMonedero;
        this.saldo = saldo;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Transaccion> getListaTransacciones() {
        return listaTransacciones;
    }

    public void setListaTransacciones(ArrayList<Transaccion> listaTransacciones) {
        this.listaTransacciones = listaTransacciones;
    }

    public Monedero getOwnedByMonedero() {
        return ownedByMonedero;
    }

    public void setOwnedByMonedero(Monedero ownedByMonedero) {
        this.ownedByMonedero = ownedByMonedero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
