package co.edu.uniquindio.poo.empresamonedero.model;

public class Notificacion {

    private TransaccionProgramada transaccionProgramada;
    private Monedero saldo;
    private Cliente cliente;
    private AnalizadorTransaccion analizadorTransaccion;

    public Notificacion(TransaccionProgramada transaccionProgramada, AnalizadorTransaccion analizadorTransaccion, Cliente cliente, Monedero saldo) {
        this.transaccionProgramada = transaccionProgramada;
        this.analizadorTransaccion = analizadorTransaccion;
        this.cliente = cliente;
        this.saldo = saldo;
    }

    public TransaccionProgramada getTransaccionProgramada() {
        return transaccionProgramada;
    }

    public void setTransaccionProgramada(TransaccionProgramada transaccionProgramada) {
        this.transaccionProgramada = transaccionProgramada;
    }

    public AnalizadorTransaccion getAnalizadorTransaccion() {
        return analizadorTransaccion;
    }

    public void setAnalizadorTransaccion(AnalizadorTransaccion analizadorTransaccion) {
        this.analizadorTransaccion = analizadorTransaccion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Monedero getSaldo() {
        return saldo;
    }

    public void setSaldo(Monedero saldo) {
        this.saldo = saldo;
    }
}
