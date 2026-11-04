package co.edu.uniquindio.poo.empresamonedero.model;

import java.util.ArrayList;

public class AnalizadorTransaccion {
    private Transaccion ownedByTransaccion;
    private Notificacion notificacion;

    public AnalizadorTransaccion(Transaccion ownedByTransaccion,Notificacion notificacion) {
        this.ownedByTransaccion=ownedByTransaccion;
        this.notificacion = notificacion;
    }

    public Transaccion getOwnedByTransaccion() {
        return ownedByTransaccion;
    }

    public void setOwnedByTransaccion(Transaccion ownedByTransaccion) {
        this.ownedByTransaccion = ownedByTransaccion;
    }

    public Notificacion getNotificacion() {
        return notificacion;
    }

    public void setNotificacion(Notificacion notificacion) {
        this.notificacion = notificacion;
    }
}
