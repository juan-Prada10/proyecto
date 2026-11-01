package co.edu.uniquindio.poo.empresamonedero.model;

import java.util.ArrayList;

public class Monedero {

    private String codigo;
    private double monto;

    private EmpresaMonedero ownedByEmpresaMonedero;
    private Cliente cliente;
    private ArrayList<DetalleMonedero> listaDetalleMonedero = new ArrayList<>();

    public Monedero(String codigo, double monto, EmpresaMonedero ownedByEmpresaMonedero, Cliente cliente) {
        this.codigo = codigo;
        this.monto = monto;
        this.ownedByEmpresaMonedero = ownedByEmpresaMonedero;
        this.cliente = cliente;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public ArrayList<DetalleMonedero> getListaDetalleMonedero() {
        return listaDetalleMonedero;
    }

    public void setListaDetalleMonedero(ArrayList<DetalleMonedero> listaDetalleMonedero) {
        this.listaDetalleMonedero = listaDetalleMonedero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public EmpresaMonedero getOwnedByEmpresaMonedero() {
        return ownedByEmpresaMonedero;
    }

    public void setOwnedByEmpresaMonedero(EmpresaMonedero ownedByEmpresaMonedero) {
        this.ownedByEmpresaMonedero = ownedByEmpresaMonedero;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
