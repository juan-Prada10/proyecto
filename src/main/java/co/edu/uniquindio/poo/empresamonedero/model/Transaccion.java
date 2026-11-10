package co.edu.uniquindio.poo.empresamonedero.model;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Transaccion {

    private String codigo;
    private LocalDate fecha;
    private double comision;
    private double monto;

    private EmpresaMonedero ownedByEmpresaMonedero;
    private Estado estado;
    private DetalleMonedero detalleMonedero;
    private Cliente cliente;
    private ArrayList<TransaccionProgramada> listaTransaccionProgramadas = new ArrayList<>();
    private ArrayList<AnalizadorTransaccion> listaAnalizadorTransacciones =  new ArrayList<>();

    public Transaccion(String codigo, Cliente cliente, DetalleMonedero detalleMonedero, Estado estado, EmpresaMonedero ownedByEmpresaMonedero, double monto, double comision, LocalDate fecha) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.detalleMonedero = detalleMonedero;
        this.estado = estado;
        this.ownedByEmpresaMonedero = ownedByEmpresaMonedero;
        this.monto = monto;
        this.comision = comision;
        this.fecha = fecha;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public ArrayList<AnalizadorTransaccion> getListaAnalizadorTransacciones() {
        return listaAnalizadorTransacciones;
    }

    public void setListaAnalizadorTransacciones(ArrayList<AnalizadorTransaccion> listaAnalizadorTransacciones) {
        this.listaAnalizadorTransacciones = listaAnalizadorTransacciones;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<TransaccionProgramada> getListaTransaccionProgramadas() {
        return listaTransaccionProgramadas;
    }

    public void setListaTransaccionProgramadas(ArrayList<TransaccionProgramada> listaTransaccionProgramadas) {
        this.listaTransaccionProgramadas = listaTransaccionProgramadas;
    }

    public DetalleMonedero getDetalleMonedero() {
        return detalleMonedero;
    }

    public void setDetalleMonedero(DetalleMonedero detalleMonedero) {
        this.detalleMonedero = detalleMonedero;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public EmpresaMonedero getOwnedByEmpresaMonedero() {
        return ownedByEmpresaMonedero;
    }

    public void setOwnedByEmpresaMonedero(EmpresaMonedero ownedByEmpresaMonedero) {
        this.ownedByEmpresaMonedero = ownedByEmpresaMonedero;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public abstract int calcularPuntos();
}
