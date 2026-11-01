package co.edu.uniquindio.poo.empresamonedero.model;

public class Cliente {
    private String documento;
    private String nombreCompleto;
    private String correo;
    private String telefono;
    private String sms;
    private String contraseña;
    private int puntos;

    private Rango rango;
    private Transaccion transaccion;
    private EmpresaMonedero ownedByEmpresaMonedero;
    private Monedero monedero;
    private TransaccionProgramada transaccionProgramada;


    public Cliente(Monedero monedero, Rango rango, Transaccion transaccion, EmpresaMonedero ownedByEmpresaMonedero, int puntos, String contraseña, String sms, String telefono, String correo, String documento, String nombreCompleto) {
        this.monedero = monedero;
        this.rango = rango;
        this.transaccion = transaccion;
        this.ownedByEmpresaMonedero = ownedByEmpresaMonedero;
        this.puntos = puntos;
        this.contraseña = contraseña;
        this.sms = sms;
        this.telefono = telefono;
        this.correo = correo;
        this.documento = documento;
        this.nombreCompleto = nombreCompleto;
    }

    public TransaccionProgramada getTransaccionProgramada() {
        return transaccionProgramada;
    }

    public void setTransaccionProgramada(TransaccionProgramada transaccionProgramada) {
        this.transaccionProgramada = transaccionProgramada;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public EmpresaMonedero getOwnedByEmpresaMonedero() {
        return ownedByEmpresaMonedero;
    }

    public void setOwnedByEmpresaMonedero(EmpresaMonedero ownedByEmpresaMonedero) {
        this.ownedByEmpresaMonedero = ownedByEmpresaMonedero;
    }

    public Monedero getMonedero() {
        return monedero;
    }

    public void setMonedero(Monedero monedero) {
        this.monedero = monedero;
    }

    public Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public Rango getRango() {
        return rango;
    }

    public void setRango(Rango rango) {
        this.rango = rango;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
}
