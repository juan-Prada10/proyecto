package co.edu.uniquindio.poo.empresamonedero.model;


import java.time.LocalDate;

public class TransaccionProgramada {

    private String codigo;
    private int recurrenci;
    private LocalDate fecha;
    private double monto;

    private Estado estado;
    private Transaccion tipoTransaccion;

    public TransaccionProgramada(String codigo, Transaccion tipoTransaccion, Estado estado, double monto, LocalDate fecha, int recurrenci) {
        this.codigo = codigo;
        this.tipoTransaccion = tipoTransaccion;
        this.estado = estado;
        this.monto = monto;
        this.fecha = fecha;
        this.recurrenci = recurrenci;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Transaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(Transaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getRecurrenci() {
        return recurrenci;
    }

    public void setRecurrenci(int recurrenci) {
        this.recurrenci = recurrenci;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
