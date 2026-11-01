package co.edu.uniquindio.poo.empresamonedero.model;

import java.util.ArrayList;

public class AnalizadorTransaccion {
    private ArrayList<Transaccion> listaTransacciones = new ArrayList<>();
    private Notificacion notificacion;

    public AnalizadorTransaccion(Notificacion notificacion) {
        this.notificacion = notificacion;
    }

    public ArrayList<Transaccion> getListaTransacciones() {
        return listaTransacciones;
    }

    public void setListaTransacciones(ArrayList<Transaccion> listaTransacciones) {
        this.listaTransacciones = listaTransacciones;
    }

    public Notificacion getNotificacion() {
        return notificacion;
    }

    public void setNotificacion(Notificacion notificacion) {
        this.notificacion = notificacion;
    }
}
