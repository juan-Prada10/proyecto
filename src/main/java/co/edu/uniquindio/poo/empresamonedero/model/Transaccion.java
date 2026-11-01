package co.edu.uniquindio.poo.empresamonedero.model;

import java.time.LocalDate;

public abstract class Transaccion {

    private String codigo;
    private LocalDate fecha;
    private double comicion;
    private double monto;

    private EmpresaMonedero ownedByEmpresaMonedero;
    private Estado estado;
    private DetalleMonedero detalleMonedero;
    private Cliente cliente;
    private TransaccionProgramada transaccionProgramada;
    private AnalizadorTransaccion ownedByAnalizadorTransaccion;

    public Transaccion(String codigo, AnalizadorTransaccion ownedByAnalizadorTransaccion, TransaccionProgramada transaccionProgramada, Cliente cliente, DetalleMonedero detalleMonedero, Estado estado, EmpresaMonedero ownedByEmpresaMonedero, double monto, double comicion, LocalDate fecha) {
        this.codigo = codigo;
        this.ownedByAnalizadorTransaccion = ownedByAnalizadorTransaccion;
        this.transaccionProgramada = transaccionProgramada;
        this.cliente = cliente;
        this.detalleMonedero = detalleMonedero;
        this.estado = estado;
        this.ownedByEmpresaMonedero = ownedByEmpresaMonedero;
        this.monto = monto;
        this.comicion = comicion;
        this.fecha = fecha;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public AnalizadorTransaccion getOwnedByAnalizadorTransaccion() {
        return ownedByAnalizadorTransaccion;
    }

    public void setOwnedByAnalizadorTransaccion(AnalizadorTransaccion ownedByAnalizadorTransaccion) {
        this.ownedByAnalizadorTransaccion = ownedByAnalizadorTransaccion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TransaccionProgramada getTransaccionProgramada() {
        return transaccionProgramada;
    }

    public void setTransaccionProgramada(TransaccionProgramada transaccionProgramada) {
        this.transaccionProgramada = transaccionProgramada;
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

    public double getComicion() {
        return comicion;
    }

    public void setComicion(double comicion) {
        this.comicion = comicion;
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
}
